package org.example;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    List<Resource> resources;

    public Utils(List<Resource> resources) {
        this.resources = resources;
    }

    public int getSum() {
        return resources.stream()
                .mapToInt(Resource::getValue)
                .sum();
    }

    public List<Integer> getMarks() {
        int totalSum = 0;
        int target = 160;
        List<Integer> marks = new ArrayList<>();

        for (Resource resource : resources) {
            totalSum += resource.getValue();
            if (totalSum >= target * (marks.size() + 1))
                marks.add(resource.getId() - 1);
        }

        return marks;
    }

    public static void getAllInfo(ArrayList<Resource> list) {
        for (Resource el : list) {
            el.printInfo();
        }
    }

    public static void getAllAnotherInfo(ArrayList<AnotherResource> list) {
        for (AnotherResource el : list) {
            el.printInfo();
        }
    }

}
