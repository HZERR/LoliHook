package ru.hzerr.loliland.loli;

import javassist.CtClass;
import ru.hzerr.bytecode.MethodByteCodeBuilder;
import ru.hzerr.loliland.loli.ext.Disable;

@Disable
public class JsonSerializer extends LoliClass {

    public JsonSerializer() {
        super("ii0ii01LanD");
    }

    @Override
    protected CtClass changeByteCode(CtClass ctClass) throws Exception {
        MethodByteCodeBuilder.init(ctClass)
                .filterByNames("toString")
                .addCode("System.out.println(\"JsonReceiver: \" + new com.google.gson.Gson().toJson(this.I1O1I1LaNd));")
//                .addCode("        for (int i = 0; i < $this.getClass().getDeclaredFields().length; i++) {\n" +
//                        "            java.lang.reflect.Field field = $this.getClass().getDeclaredFields()[i];\n" +
//                        "            System.out.println(\"JsonSerializer field: \" + field.getName());\n" +
//                        "        }")
                .insertBefore();

        return ctClass;
    }
}
