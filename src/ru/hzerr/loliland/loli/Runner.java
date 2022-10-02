package ru.hzerr.loliland.loli;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.FieldAccess;
import ru.hzerr.bytecode.MethodByteCodeBuilder;

import java.util.Arrays;

public class Runner extends LoliClass {

    public Runner() {
        super("lIIiO0laNd");
    }
    @Override
    protected CtClass changeByteCode(CtClass ctClass) throws Exception {
        MethodByteCodeBuilder.init(ctClass)
                .filterByNames("I1O1I1LaNd")
                .filter(ctMethod -> {
                    try {
                        return Arrays.stream(ctMethod.getParameterTypes()).noneMatch(type -> type.getName().contains("OOOOllANd")) &&
                                Arrays.stream(ctMethod.getParameterTypes()).noneMatch(type -> type.getName().contains("i1i1OlLaNd"));
                    } catch (NotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }).getMethods().get(0).instrument(new ExprEditor() {
                    @Override
                    public void edit(FieldAccess f) throws CannotCompileException {
                        System.out.println("Access: " + f.getFieldName());
                        super.edit(f);
                    }
                });
        return ctClass;
    }
}
