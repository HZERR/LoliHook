package ru.hzerr.loliland.loli;

import javassist.CtClass;
import ru.hzerr.bytecode.MethodByteCodeBuilder;

public class Watcher extends LoliClass {

    public Watcher() { super("O1liIliLand"); }

    @Override
    protected CtClass changeByteCode(CtClass ctClass) throws Exception {
        MethodByteCodeBuilder.init(ctClass)
                .filterByNames("lI00OlAND")
                .addCode("return null;")
                .insertBody();
        return ctClass;
    }
}
