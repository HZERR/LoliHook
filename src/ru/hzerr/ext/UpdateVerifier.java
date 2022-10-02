package ru.hzerr.ext;

import ru.hzerr.file.BaseDirectory;
import ru.hzerr.file.HDirectory;
import ru.hzerr.file.SizeType;

public final class UpdateVerifier {

    private static final BaseDirectory oldDirectoryWithProject = new HDirectory("C:\\Users\\HZERR\\Desktop\\Loli-Source 08.07.2022");
    private static final BaseDirectory newDirectoryWithProject = new HDirectory("C:\\Users\\HZERR\\Desktop\\Loli-Source\\Loli Source");

    public static void main(String[] args) {
        System.out.println("Old size: " + oldDirectoryWithProject.sizeOf(SizeType.KB));
        System.out.println("New size: " + newDirectoryWithProject.sizeOf(SizeType.KB));
        System.out.println("Identity: " + (oldDirectoryWithProject.sizeOf(SizeType.BYTE) == newDirectoryWithProject.sizeOf(SizeType.BYTE)));
    }
}
