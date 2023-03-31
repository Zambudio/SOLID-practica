package com.kreitek.interfaces;

import java.util.List;

public interface FileSystemItem {
    // para filesystemitembase
    String getName();
    void setName(String name);
    FileSystemItem getParent();
    void setParent(FileSystemItem directory);
    String getFullPath();
    int getSize();
    List<FileSystemItem> listFiles();


    // en directory NO, ficheros SI
    String getExtension();
    void open();
    void close();
    void setPosition(int numberOfBytesFromBeginning);
    byte[] read(int numberOfBytesToRead);
    void write(byte[] buffer);


    // ficheros NO , directorios SI
    void removeFile(FileSystemItem file);
    void addFile(FileSystemItem file);

}
