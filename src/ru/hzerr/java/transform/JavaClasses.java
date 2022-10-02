package ru.hzerr.java.transform;

import java.util.Arrays;
import java.util.Optional;

public enum JavaClasses {

    PROCESS_BUILDER(new ProcessBuilder());

    private final JavaClass clazz;

    JavaClasses(JavaClass javaClass) { this.clazz = javaClass; }

    public JavaClass getJavaClass() { return this.clazz; }

    public static Optional<JavaClasses> getJavaClass(String name) {
        return name.equals("ProcessBuilder") ? Optional.of(PROCESS_BUILDER) : Optional.empty();
//        return Arrays.stream(values()).filter(streamClasses -> name.equals(streamClasses.getJavaClass().getName())).findFirst();
    }
}
