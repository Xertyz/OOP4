package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class DataProcessor<T extends Resource> {

    private final List<T> resources;

    public DataProcessor(List<T> resources) {
        this.resources = resources;
    }

    public List<AnotherResource> filterByCondition(int lowerLimit, int upperLimit, int limit) throws LogicException {

        if (lowerLimit > upperLimit || limit < 0) {
            throw new LogicException("Wrong limits, please, try again");
        }

        return resources.stream()
                .filter(el -> el.getValue() > lowerLimit && el.getValue() < upperLimit)
                .sorted(Comparator.comparingInt(Resource::getValue))
                .limit(limit)
                .map(el -> new AnotherResource(el.getValue()))
                .toList();
    }

    public Optional<AnotherResource> findByValue(int value) throws LogicException {
        if (value < 0) {
            throw new LogicException("Wrong value, please, try again");
        }
        return resources.stream()
                .filter(el -> el.getValue() == value)
                .map(el -> new AnotherResource(el.getValue()))
                .findFirst();
    }
}
