package ru.hzerr.java;

import javassist.ClassPool;
import javassist.CtClass;
import ru.hzerr.java.transform.JavaClasses;
import ru.hzerr.loliland.loli.ext.Disable;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class JavaHookTransformer {

    public static byte[] transform(byte[] bytes) throws IOException {
        CtClass clazz = ClassPool.getDefault().makeClass(new ByteArrayInputStream(bytes));
        return JavaClasses
                .getJavaClass(clazz.getSimpleName())
                .filter(loliClasses -> !loliClasses.getJavaClass().getClass().isAnnotationPresent(Disable.class))
                .map(loliClasses -> {
                    try {
                        System.out.println("Modification of java class " + clazz.getSimpleName());
                        return loliClasses.getJavaClass().getChangedByteCode(clazz);
                    } catch (Exception e) {
                        System.err.println("Ошибка модификации класса " + loliClasses.getJavaClass().getClass().getSimpleName() + "!!!");
                        e.printStackTrace();
                    }

                    return bytes;
                })
                .orElse(bytes);
    }
}
