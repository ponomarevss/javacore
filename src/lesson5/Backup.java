package lesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Backup {
    /**
     * Save to backup.
     *
     * @param sourceDirString the source dir string
     * @param targetDirString the target dir string
     */
    public static void saveToBackup(String sourceDirString, String targetDirString) {
        createBackupDir(targetDirString);
        copyFilesToTargetDir(sourceDirString, targetDirString);
    }

    private static void createBackupDir(String targetDirString) {
        try {
            Files.createDirectory(Path.of(targetDirString));
            System.out.printf("Directory %s created%n", targetDirString);
        } catch (IOException e) {
            System.err.println("Failed to create directory: " + e.getMessage());
        }
    }

    private static void copyFilesToTargetDir(String sourceDirString, String targetDirString) {
        File sourceDir = new File(sourceDirString);
        File[] files = sourceDir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (!f.isDirectory()) {
                    try {
                        Files.copy(f.toPath(), Path.of(targetDirString, f.getName()));
                        System.out.printf("File %s copied to %s%n", f.getName(), targetDirString);
                    } catch (IOException e) {
                        System.err.println("Failed to copy file: " + e.getMessage());
                    }
                }
            }
        } else {
            throw new NullPointerException("directory.listFiles() is null");
        }
    }
}
