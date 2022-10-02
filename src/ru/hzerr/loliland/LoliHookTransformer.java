package ru.hzerr.loliland;

import javassist.ClassPool;
import javassist.CtClass;
import ru.hzerr.loliland.loli.LoliClasses;
import ru.hzerr.loliland.loli.ext.Disable;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class LoliHookTransformer {

    /*
     * Modifies the launcher byte code
     * Returns modified bytecode
     */
    public static byte[] transform(byte[] bytes) throws IOException {
        CtClass clazz = ClassPool.getDefault().makeClass(new ByteArrayInputStream(bytes));
        return LoliClasses
                .getLoliClass(clazz.getSimpleName())
                .filter(loliClasses -> !loliClasses.getLoliClass().getClass().isAnnotationPresent(Disable.class))
                .map(loliClasses -> {
                    try {
                        System.out.println("Modification of Loliland class " + loliClasses.getLoliClass().getClass().getSimpleName());
                        return loliClasses.getLoliClass().getChangedByteCode(clazz);
                    } catch (Exception e) {
                        System.err.println("Error in the modification of the class " + loliClasses.getLoliClass().getClass().getSimpleName() + "!!!");
                        e.printStackTrace();
                    }

                    return bytes;
                })
                .orElse(bytes);
    }
}
