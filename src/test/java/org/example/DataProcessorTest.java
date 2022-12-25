package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {

    private final List<Resource> resourcesTest =  Arrays.asList(
            new Resource(1, 50),
            new Resource(2, 30),
            new Resource(3, 90),
            new Resource(4, 60)
    );

    private final DataProcessor<Resource> dpResourcesTest = new DataProcessor<>(resourcesTest);


    @DisplayName("Filter by condition")
    @Test
    void filterByCondition() throws LogicException {
        List<AnotherResource> anotherResources = Arrays.asList(
                new AnotherResource(50),
                new AnotherResource(60)
        );
        List<AnotherResource> dpResult = dpResourcesTest.filterByCondition(30, 90, 2);

        int i = 0;
        for (AnotherResource r : dpResult) {
            if (r.getValue() != anotherResources.get(i++).getValue())
                fail();
        }
    }

    @DisplayName("Filter by condition with non-existent range")
    @Test
    void filterWithWrongRange(){
        assertThrows(LogicException.class,
                () -> dpResourcesTest.filterByCondition(10, -10, 0)
        );
    }

    @DisplayName("Filter by condition with non-existent limit")
    @Test
    void filterWithWrongLimit() {
        assertThrows(LogicException.class,
                () -> dpResourcesTest.filterByCondition(10, 100, -10)
        );
    }

    @DisplayName("Filter by condition empty list")
    @Test
    void filterEmptyList() throws LogicException {
        assertTrue(dpResourcesTest.filterByCondition(10, 20, 0).isEmpty());
    }

    @DisplayName("Find by value")
    @Test
    void findByValue() throws LogicException {
        assertEquals(new AnotherResource(50).getValue(),
                dpResourcesTest.findByValue(50).get().getValue());
    }

    @DisplayName("Find non-existent value")
    @Test
    void findNonexistentValue() throws LogicException {
        assertEquals(Optional.empty(), dpResourcesTest.findByValue(1000));
    }

    @DisplayName("Find wrong value")
    @Test
    void findWrongValue(){
        assertThrows(LogicException.class,
                () -> dpResourcesTest.findByValue(-10));
    }

}