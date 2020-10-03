package com.bilgeadam.java.examples.life_calculator.creatures;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class AntTest {
    private Ant antOne, antTwo;
    private final short birthday = 1;
    private final int x = 2;
    private final int y = 3;

    @BeforeEach
    void setUp() {
        antOne = new Ant(birthday, x, y);
        antTwo = new Ant(birthday, x, y);
    }

    @AfterEach
    void tearDown() {
        antOne = null;
        antTwo = null;
    }

    @Test
    void isCompatible() {
        if (antOne.getSex() == Gender.Female && antTwo.getSex() == Gender.Male)
            assertNotNull(antOne.copulate(antTwo));
        else
            assertNull(antOne.copulate(antTwo));
    }

}