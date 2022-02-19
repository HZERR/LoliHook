package ru.hzerr.loli;

import java.util.Arrays;
import java.util.Optional;

public enum LoliClasses {

    UPDATER(new Updater());

    private final LoliClass clazz;

    LoliClasses(LoliClass loliClass) { this.clazz = loliClass; }

    public LoliClass getLoliClass() { return this.clazz; }

    public static Optional<LoliClasses> getLoliClass(String name) {
        return Arrays.stream(values()).filter(streamClasses -> name.equals(streamClasses.getLoliClass().getName())).findFirst();
    }
}
