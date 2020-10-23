package com.bilgeadam.java.tutorials.custom_exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This exception writes itself to a file.
 */
public class FileNotFoundLoggerException extends FileNotFoundException {
    private final String path = "src" + File.separator + "resources" + File.separator;

    /**
     *
     * @param fileName File to write
     * @param log      Log message to write
     * @throws IOException Occurs if no file is found
     */
    private void logException(String fileName, String log) throws IOException {
        File f;
        FileWriter fileWriter = null;
        try {
            f = new File(path + fileName);
            fileWriter = new FileWriter(f);
            fileWriter.write(log);
        } finally {
            assert fileWriter != null;
            fileWriter.close();
        }
    }

    /**
     * Constructs a {@code FileNotFoundException} with the
     * specified detail message. The string {@code s} can be
     * retrieved later by the
     * <code>{@link Throwable#getMessage}</code>
     * method of class {@code java.lang.Throwable}.
     *
     * @param s the detail message.
     */
    public FileNotFoundLoggerException(String s) throws IOException {
        logException("File.txt", s);
    }
}
