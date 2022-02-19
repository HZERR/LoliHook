package ru.hzerr;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

// C:\Users\HZERR\AppData\Roaming\.loliland\java\bin\java.exe -javaagent:"LoliHook.jar" -jar C:\Users\HZERR\AppData\Roaming\.loliland\launcher.jar

public class LoliHookAgent implements ClassFileTransformer {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Injecting...");
        inst.addTransformer(new LoliHookAgent());
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        try {
            if (className != null && className.contains("loliland"))
                return LoliHookTransformer.transform(classfileBuffer);
        } catch (Throwable th) { th.printStackTrace(); }
        return classfileBuffer;
    }
}
