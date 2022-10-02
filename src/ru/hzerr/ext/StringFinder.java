package ru.hzerr.ext;

import ru.hzerr.collections.list.HList;
import ru.hzerr.file.BaseDirectory;
import ru.hzerr.file.BaseFile;
import ru.hzerr.file.HDirectory;

import java.io.IOException;
import java.nio.charset.Charset;

public class StringFinder {

    // l0OO0lllAnd - UPDATER

    private static final String target = "ProcessBuilder"; // ExecutorService scheduleAtFixedRate TimerTask
    private static final BaseDirectory watchDirectory = new HDirectory("C:\\Users\\HZERR\\Desktop\\source");

    public static void main(String[] args) throws IOException {
        find(watchDirectory);
    }

    private static void find(BaseDirectory directory) throws IOException {
        directory.getAllFiles(false).forEach(obj -> {
            if (obj.asIOFile().isDirectory()) {
                find((BaseDirectory) obj);
            } else
                print((BaseFile) obj);
        }, IOException.class);
    }

    private static void print(BaseFile file) throws IOException {
        HList<String> lines = file.readLines(Charset.defaultCharset());
        if (lines.anyMatch(line -> line.contains(target))) {
            System.out.println("TARGET FOUND: " + file.getLocation());
        }
    }
}
