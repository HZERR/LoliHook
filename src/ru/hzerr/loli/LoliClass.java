package ru.hzerr.loli;

import javassist.CtClass;
import ru.hzerr.bytecode.ByteCodeBuilder;
import ru.hzerr.bytecode.ClassByteCodeBuilder;

public abstract class LoliClass {

    private final String name;

    protected LoliClass() { this.name = this.getClass().getSimpleName(); }
    protected LoliClass(String className) { this.name = className; }

    public final String getName() { return this.name; }

    public final byte[] getChangedByteCode(CtClass ctClass) throws Exception {
        return ClassByteCodeBuilder.init(this.changeByteCode(ctClass)).toBytecode();
    }

    /*
     * This method contains the logic of changing the bytecode of the class.
     * Returns CtClass. DO NOT DELETE CtClass from ClassPool! Don't use detach() for the current CtClass
     */
    protected abstract CtClass changeByteCode(CtClass ctClass) throws Exception;
}
