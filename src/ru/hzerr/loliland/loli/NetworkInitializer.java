package ru.hzerr.loliland.loli;

import javassist.CtClass;
import javassist.NotFoundException;
import ru.hzerr.bytecode.CPSettings;
import ru.hzerr.bytecode.MethodByteCodeBuilder;

public class NetworkInitializer extends LoliClass {

    public NetworkInitializer() {
        super("i1i0lOliLaND");
    }

    @Override
    protected CtClass changeByteCode(CtClass ctClass) throws Exception {
        MethodByteCodeBuilder.init(ctClass)
                .filterByNames("toString")
                .addPrintlnStackTraceWithTab()
                .insertBefore();
        MethodByteCodeBuilder.init(ctClass)
                .filter(method -> {
                    try {
                        boolean found = method.getName().equals("I1O1I1LaNd") &&
                                method.getReturnType().getClass().equals(CPSettings.create().getClassPool().makeClass("java.net.NetworkInterface").getClass());
                        if (found) System.out.println("NETWORK INTERFACE GETTER WAS FOUND");
                        return found;
                    } catch (NotFoundException notFoundException) {
                        System.err.println("NetworkInitializer | I1O1I1LaNd method not found");
                        return false;
                    }
                })
                .addPrintlnStackTraceWithTab()
                .insertBefore();
        return ctClass;
    }
}
