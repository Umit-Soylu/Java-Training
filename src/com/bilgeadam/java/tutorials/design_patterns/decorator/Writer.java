package com.bilgeadam.java.tutorials.design_patterns.decorator;

import java.io.File;

public interface Writer {
    void targetFile(File file);

    void printToFile(String line);
}
