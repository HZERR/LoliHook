package ru.hzerr.java.transform;

import javassist.CtClass;
import ru.hzerr.bytecode.MethodByteCodeBuilder;

public abstract class JavaClass {

    private final String name;

    protected JavaClass() { this.name = this.getClass().getSimpleName(); }
    protected JavaClass(String className) { this.name = className; }

    public final String getName() { return this.name; }

    public final byte[] getChangedByteCode(CtClass ctClass) throws Exception {
        return MethodByteCodeBuilder.init(changeByteCode(ctClass)).toBytecode();
    }

    /*
     * This method contains the logic of changing the bytecode of the class.
     * Returns CtClass. DO NOT DELETE CtClass from ClassPool! Don't use detach() for the current CtClass
     */
    protected abstract CtClass changeByteCode(CtClass ctClass) throws Exception;
}
