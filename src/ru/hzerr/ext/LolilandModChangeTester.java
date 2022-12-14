package ru.hzerr.ext;

import ru.hzerr.file.BaseDirectory;
import ru.hzerr.file.BaseFile;
import ru.hzerr.file.HDirectory;
import ru.hzerr.file.HFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// C:\Users\HZERR\AppData\Roaming\.loliland

public class LolilandModChangeTester {

    private static final ScheduledExecutorService checker = Executors.newSingleThreadScheduledExecutor();
    private static final BaseDirectory mods = new HDirectory("C:\\Users\\HZERR\\loliland\\updates\\clients\\nano_magic\\mods");
    private static BaseFile currentLiquidBounce = null;
    private static BaseFile targetLiquidBounce = null;

    static {
        try {
            currentLiquidBounce = HFile.from(new File(Objects.requireNonNull(LolilandModChangeTester.class.getResource("/ForgeWurst-0.11-MC1.12.2.jar")).toURI()));
            targetLiquidBounce = mods.getSubFile(currentLiquidBounce.getBaseName());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        currentLiquidBounce.copyToDirectory(mods);
        checker.scheduleAtFixedRate(() -> {
            if (targetLiquidBounce.notExists()) {
                try {
                    currentLiquidBounce.copyToDirectory(mods);
                } catch (IOException e) {
                    System.out.println("Готово!");
                    checker.shutdownNow();
                }
            }
        }, 0L, 200L, TimeUnit.MILLISECONDS);
    }
}
