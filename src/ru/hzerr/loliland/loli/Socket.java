package ru.hzerr.loliland.loli;

import javassist.CtClass;
import javassist.NotFoundException;
import ru.hzerr.bytecode.MethodByteCodeBuilder;

import java.util.Arrays;

public class Socket extends LoliClass {

    public Socket() { super("l0il0l1iLaNd"); }

    @Override
    protected CtClass changeByteCode(CtClass ctClass) throws Exception {
        MethodByteCodeBuilder.init(ctClass)
                .filterByNames("I1O1I1LaNd")
                .filter(ctMethod -> {
                    try {
                        return Arrays.stream(ctMethod.getParameterTypes()).noneMatch(type -> type.getName().contains("ii0ii01LanD"));
                    } catch (NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .addCode("System.out.println(\"HZERR | Sending request: \" + ($1 + $2));")
                .insertBefore()
                .concatMethodByteCodeBuilder()
                .filterByNames("OOOIilanD")
                .filter(ctMethod -> {
                    try {
                        return Arrays.stream(ctMethod.getParameterTypes()).noneMatch(type -> type.getName().contains("String"));
                    } catch (NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .addPrintln("\"HZERR | Sending request: \" + $1")
                .insertBefore();
        return ctClass;
    }
}
