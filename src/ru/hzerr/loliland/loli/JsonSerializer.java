package ru.hzerr.loliland.loli;

import javassist.CtClass;
import ru.hzerr.bytecode.MethodByteCodeBuilder;

public class JsonSerializer extends LoliClass {

    public JsonSerializer() {
        super("ii0ii01LanD");
    }

    @Override
    protected CtClass changeByteCode(CtClass ctClass) throws Exception {
        MethodByteCodeBuilder.init(ctClass)
                .filterByNames("toString")
                .addCode("System.out.println(\"JsonReceiver: \" + new com.google.gson.Gson().toJson(this.I1O1I1LaNd));")
                .insertBefore();

        return ctClass;
    }
}
