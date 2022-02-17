package ru.hzerr;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class LoliHookAgent implements ClassFileTransformer {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Injecting...");
        inst.addTransformer(new LoliHookAgent());
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        return new byte[0];
    }
}
