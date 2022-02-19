package ru.hzerr.loli;

import javassist.CtClass;
import javassist.CtMethod;

public class Updater extends LoliClass {

    public Updater() { super("l0OO0lllAnd"); }

    @Override
    protected CtClass changeByteCode(CtClass ctClass) throws Exception {
        CtMethod method = ctClass.getDeclaredMethod("I1O1I1LaNd");
        method.setBody("return;");
        return ctClass;
    }
}
