package ru.hzerr;

import ru.hzerr.java.JavaHookTransformer;
import ru.hzerr.loliland.LoliHookTransformer;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

// java -javaagent:"LoliHook.jar" -jar C:\Users\HZERR\AppData\Roaming\.loliland\launcher.jar -Xverify:all -Dorg.slf4j.simpleLogger.defaultLogLevel=debug
/*
cd $Env:Programfiles\BellSoft\LibericaJDK-8-Full\bin\
java.exe -javaagent:"C:\Users\HZERR\Desktop\LoliHook\build\LoliHook.jar" -jar "C:\Users\HZERR\AppData\Roaming\.loliland\launcher.jar"
 */

public class LoliHookAgent implements ClassFileTransformer {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Injecting...");
        inst.addTransformer(new LoliHookAgent());
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        try {
            if (className != null) {
                if (className.contains("loliland")) return LoliHookTransformer.transform(classfileBuffer);
                if (className.contains("java/lang/") && !className.contains("java/lang/invoke") && !className.contains("java/io")) return JavaHookTransformer.transform(classfileBuffer);
            }
        } catch (Throwable th) { th.printStackTrace(); }

        return classfileBuffer;
    }
}
