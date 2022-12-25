package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opCount = 1;
        ArrayList<Resource> resources = new ArrayList<>();

        while (true) {
            String value = scanner.next();
            if (value.equals("break")) {
                break;
            } else {
                try {
                    int num = Integer.parseInt(value);
                    if (num >= 0) {
                        resources.add(new ResConsumption(opCount, num));
                    } else {
                        resources.add(new ResIncome(opCount, num));
                    }
                    opCount++;
                } catch (NumberFormatException e) {
                    System.out.println("Wrong value, try again");
                }
            }
        }

        System.out.println("---All elements---");
        Utils.getAllInfo(resources);

        System.out.println("---Statistics---");
        Utils uResources = new Utils(resources);
        int sum = uResources.getSum();
        System.out.println("Sum: " + sum);
        List<Integer> marks = uResources.getMarks();
        System.out.println("Marks: " + marks);

        System.out.println("------Filter------");
        boolean correctParameters = false;
        DataProcessor<Resource> dpResource = new DataProcessor<>(resources);

        while (!correctParameters) {
            try {
                System.out.println("Please, input lower limit");
                int lowerLimit = inputNumber();
                System.out.println("Please, input upper limit");
                int upperLimit = inputNumber();
                System.out.println("Please, input limit");
                int limit = inputNumber();

                List<AnotherResource> anotherResources = dpResource.filterByCondition(lowerLimit, upperLimit, limit);
                Utils.getAllAnotherInfo(new ArrayList<>(anotherResources));
                correctParameters = true;
            } catch (LogicException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("------Search------");
        System.out.println("Please, input required number");
        int neededValue = inputNumber();
        try {
            Optional<AnotherResource> neededEl = dpResource.findByValue(neededValue);
            if (neededEl.isPresent()) {
                neededEl.get().printInfo();
            } else {
                System.out.println("No such element found");
            }
        } catch (LogicException e) {
            System.out.println(e.getMessage());
        }
    }

    protected static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Wrong value, try again");
            }
        }
    }
}




