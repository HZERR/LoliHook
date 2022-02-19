package ru.hzerr;

import javassist.ClassPool;
import javassist.CtClass;
import ru.hzerr.bytecode.ByteCodeBuilderFactory;
import ru.hzerr.loli.LoliClasses;
import ru.hzerr.loli.ext.Disable;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class LoliHookTransformer {

    /*
     * Modifies the launcher byte code
     * Returns modified bytecode
     */
    public static byte[] transform(byte[] bytes) throws IOException {
        CtClass clazz = ClassPool.getDefault().makeClass(new ByteArrayInputStream(bytes));
        System.out.println("Modification of class " + clazz.getSimpleName());
        return LoliClasses
                .getLoliClass(clazz.getSimpleName())
                .filter(loliClasses -> !loliClasses.getLoliClass().getClass().isAnnotationPresent(Disable.class))
                .map(loliClasses -> {
                    try {
                        return loliClasses.getLoliClass().getChangedByteCode(clazz);
                    } catch (Exception e) {
                        System.err.println("Ошибка модификации класса!!!");
                        e.printStackTrace();
                    }

                    return bytes;
                })
                .orElse(bytes);
    }
}
