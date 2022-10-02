package ru.hzerr.ext;

import ru.hzerr.loliland.loli.LoliClasses;

import java.util.Arrays;
import java.util.Optional;

public final class LoliClassNameFinder {

    private static final String className = "ii0ii01LanD";

    public static void main(String[] args) {
        Optional<LoliClasses> clazz = Arrays.stream(LoliClasses.values()).filter(loliClasses -> loliClasses.getLoliClass().getName().equals(className)).findFirst();
        clazz.ifPresent(cl -> System.out.println("Class was found: " + cl.getLoliClass().getClass().getSimpleName()));
    }
}
