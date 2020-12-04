package com.bilgeadam.java.tutorials.jdbc.connection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectorTest {
    Connector testClass;

    @BeforeEach
    void setUp() {
        testClass = new Connector();
    }

    @AfterEach
    void tearDown() {
        testClass = null;
    }

    @Test
    void getConnection() {
        assertDoesNotThrow(() -> testClass.getConnection());
    }
}