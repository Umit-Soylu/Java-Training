package com.bilgeadam.java.tutorials.design_patterns.decorator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter implements Writer{
    File f;

    public LogWriter() throws IOException {
    }

    @Override
    public void targetFile(File file) {
        f.exists();
    }

    @Override
    public void printToFile(String line) {
        FileWriter writer = null;
        try {
             writer = new FileWriter(f);
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert writer != null;
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
