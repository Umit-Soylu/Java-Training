package com.bilgeadam.java.tutorials.custom_exceptions;

import java.io.FileNotFoundException;

public class UnknownFileException extends FileNotFoundException {
    private static final String message = "This file does not exist in our server.";

    /**
     * Constructs a {@code FileNotFoundException} with
     * {@code null} as its error detail message.
     */
    public UnknownFileException() {
        super(message);
    }
}
