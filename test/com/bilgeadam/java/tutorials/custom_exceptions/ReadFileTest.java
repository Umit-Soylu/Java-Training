package com.bilgeadam.java.tutorials.custom_exceptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ReadFileTest {
    ReadFile testClass;
    @BeforeEach
    void setUp() {
        testClass = new ReadFile();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void myExceptionThrower() {
        assertThrows(UnknownFileException.class, ()-> testClass.myExceptionThrower());
    }

    @Test
    void fileExceptionThrower() {
        assertThrows(FileNotFoundException.class, ()-> testClass.fileExceptionThrower());
    }

    @Test
    void fileExceptionLogger() {
        assertThrows(FileNotFoundLoggerException.class, ()-> testClass.fileExceptionLogger());
    }
}