package ru.hzerr;

import javassist.ClassPool;
import javassist.CtClass;
import ru.hzerr.bytecode.ByteCodeBuilderFactory;

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
        return ByteCodeBuilderFactory.createMethodByteCodeBuilder(bytes)
                .filterByNames("I1O1I1LaNd")
                .setEmptyBody()
                .toBytecode();
    }
}
