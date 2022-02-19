package ru.hzerr;

import ru.hzerr.file.BaseDirectory;
import ru.hzerr.file.BaseFile;
import ru.hzerr.file.HDirectory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class StringFinder {

    // l0OO0lllAnd - UPDATER

    private static final String target = "OIi01Ol1LaNd"; // ExecutorService
    private static final BaseDirectory watchDirectory = new HDirectory("C:\\Users\\HZERR\\IdeaProjects\\Loli-Source\\Loli Source\\loliland");

    public static void main(String[] args) throws IOException {
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
