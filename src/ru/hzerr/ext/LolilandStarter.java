package ru.hzerr.ext;

import java.io.File;
import java.io.IOException;

public class LolilandStarter {

    public static void main(String[] args) throws IOException {
        ProcessBuilder builder = new ProcessBuilder();
        builder.directory(new File("C:\\Program Files\\BellSoft\\LibericaJDK-8-Full\\bin"));
        builder.command("java.exe", "-javaagent:\"C:\\Users\\HZERR\\Desktop\\LoliHook\\build\\LoliHook.jar\"", "-jar", "\"C:\\Users\\HZERR\\AppData\\Roaming\\.loliland\\launcher.jar\"");
        builder.inheritIO();
        builder.start();
    }
}
