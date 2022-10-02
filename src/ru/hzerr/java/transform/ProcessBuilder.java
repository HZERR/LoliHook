package ru.hzerr.java.transform;

import javassist.CtClass;
import javassist.NotFoundException;
import ru.hzerr.bytecode.ConstructorByteCodeBuilder;

import java.util.Arrays;

public class ProcessBuilder extends JavaClass {

    public ProcessBuilder() {
        super("ProcessBuilder");
    }
    @Override
    protected CtClass changeByteCode(CtClass ctClass) throws Exception {
        ConstructorByteCodeBuilder.init(ctClass)
                .filter(ctConstructor -> {
                    try {
                        return Arrays.stream(ctConstructor.getParameterTypes()).noneMatch(type -> type.getName().contains("List"));
                    } catch (NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .addCode("{" +
                        "for (int i = 0; i < $1.size(); i++) {\n" +
                        "            System.out.println($1.get(i));\n" +
                        "        }" +
//                        "$1.set(0, ((String)$1.get(0)).replace(\"javaw.exe\", \"java\"));" +
                        "}")
                .insertBefore();
//        List<String> l = new LinkedList<>();
//        l.set(0, l.get(0).replace("javaw.exe", "javaw.so"));
//        for (int i = 0; i < l.size(); i++) {
//            System.out.println(l.get(i));
//        }
        return ctClass;
    }
}
