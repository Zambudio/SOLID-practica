package com.kreitek.interfaces;

import com.kreitek.interfaces.FileSystemItem;

public interface DirectoryOperations {

    void removeFile(FileSystemItem file);
    void addFile(FileSystemItem file);

}
