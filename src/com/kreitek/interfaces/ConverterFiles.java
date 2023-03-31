package com.kreitek.interfaces;

import com.kreitek.files.FileReadWrite;

public interface ConverterFiles {
    FileReadWrite convertMp3ToWav();
    FileReadWrite convertWavToMp3();
}
