package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    private final List<Resource> uResourcesEmptyTest = new ArrayList<>();

    private final List<Resource> uResourcesTest =  Arrays.asList(
            new ResConsumption(1, 50),
            new ResIncome(2, 30),
            new ResConsumption(3, 90),
            new ResConsumption(4, 60),
            new ResIncome(5, 10),
            new ResConsumption(6, 70),
            new ResIncome(7, 0),
            new ResConsumption(8, 100),
            new ResConsumption(9, 60),
            new Worker("Billy"),
            new Worker("Steve")
    );

    private final Utils utilsEmptyTest = new Utils(uResourcesEmptyTest);

    private final Utils utilsTest = new Utils(uResourcesTest);

    @DisplayName("Get total sum")
    @Test
    void getSum() {
        assertEquals(390, utilsTest.getSum());
    }

    @DisplayName("Get sum of empty list")
    @Test
    void getSumOfEmptyList() {
        assertEquals(0, utilsEmptyTest.getSum());
    }

    @DisplayName("Get marks")
    @Test
    void getMarks() {
        assertEquals(Arrays.asList(3, 7), utilsTest.getMarks());
    }

    @DisplayName("Get marks of empty list")
    @Test
    void getMarksOfEmptyList() {
        assertEquals(new ArrayList<Integer>(), utilsEmptyTest.getMarks());
    }
}