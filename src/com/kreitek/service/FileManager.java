package com.kreitek.service;

import com.kreitek.files.Directory;
import com.kreitek.files.FileReadWrite;
import com.kreitek.files.FileSystemItem;

import java.util.List;

public class FileManager {

    public static int calculateSize(FileSystemItem fileSystemItem) {
        int totalSize = 0;

        if (fileSystemItem instanceof FileReadWrite) {
            totalSize = fileSystemItem.getSize();
        } else if (fileSystemItem instanceof Directory) {
            for (FileSystemItem item : fileSystemItem.listFiles()) {
                totalSize += calculateSize(item);
            }
        }

        return totalSize;
    }

    public static int calculateSize(List<FileSystemItem> files) {
        int totalSize = 0;

        for(FileSystemItem item : files) {
            if (item instanceof FileReadWrite) {
                totalSize += item.getSize();
            } else if (item instanceof Directory) {
                totalSize += calculateSize(item.listFiles());
            }
        }

        return totalSize;
    }

    // Aquí habría otros métodos para gestionar ficheros y directorios:
    // Crear ficheros, mover ficheros, eliminar ficheros, etc.
}
