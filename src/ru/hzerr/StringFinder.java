package ru.hzerr;

import ru.hzerr.file.BaseDirectory;
import ru.hzerr.file.BaseFile;
import ru.hzerr.file.HDirectory;

import java.io.IOException;
import java.nio.charset.Charset;

public class StringFinder {

    // l0OO0lllAnd - UPDATER

    private static final String target = "toRemove";
    private static final BaseDirectory watchDirectory = new HDirectory("C:\\Users\\HZERR\\Desktop\\Loli Source");

    public static void main(String[] args) throws IOException {
//        watchDirectory.getFiles().wrap(Throwable::printStackTrace).forEach(file -> {
//            System.out.println("Check " + file.getName());
//            if (file.readLines(Charset.defaultCharset()).forEach(System.out::println).filter(line -> line.contains(target)).findFirst().isPresent()) {
//                System.out.println("TARGET FOUND: " + file.getName());
//            }
//        });
        find(watchDirectory);
    }

    private static void find(BaseDirectory directory) throws IOException {
        directory.getAllFiles(false).forEach(obj -> {
            if (obj.asIOFile().isDirectory()) {
                find((BaseDirectory) obj);
            } else
                print((BaseFile) obj);
        });
    }

    private static void print(BaseFile file) throws IOException {
        if (file.readLines(Charset.defaultCharset()).filter(line -> line.contains(target)).findFirst().isPresent()) {
            System.out.println("TARGET FOUND: " + file.getLocation());
        }
    }
}
