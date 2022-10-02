package ru.hzerr.loliland.loli;

import javassist.CtClass;
import ru.hzerr.bytecode.MethodByteCodeBuilder;

import java.util.Arrays;

public class Updater extends LoliClass {

    public Updater() { super("l0OO0lllAnd"); }

    @Override
    protected CtClass changeByteCode(CtClass ctClass) throws Exception {
        System.out.println("Трансформация updater-а...");
        System.out.println("Методы updater-класса:");
        Arrays.stream(ctClass.getDeclaredMethods()).forEach(method -> System.out.println("\tMethod: " + method.getLongName()));
        MethodByteCodeBuilder.init(ctClass)
                .filterByNames("I1O1I1LaNd")
                .setEmptyBody();
        return ctClass;
    }
}
