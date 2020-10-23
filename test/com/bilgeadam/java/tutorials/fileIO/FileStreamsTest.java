package com.bilgeadam.java.tutorials.fileIO;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class FileStreamsTest {
    FileStreams testClass;

    @BeforeEach
    void setUp() {
        testClass = new FileStreams();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void printResults() {
        assertDoesNotThrow(()-> testClass.printResults());

    }

    @Test
    void printCharArray() {
        assertDoesNotThrow(()-> testClass.printToFile(this.getClass().getSimpleName()));
    }

    @Test
    void writeInputToFile() throws IOException {
        testClass.readFromFile();
    }

    @Test
    void readStream() {
        assertDoesNotThrow(()-> FileStreams.readStream("Terminal"));
    }
}