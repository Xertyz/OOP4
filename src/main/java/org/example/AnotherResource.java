package org.example;

public class AnotherResource implements Printer {

    private int value;

    public AnotherResource(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void printInfo() {
        System.out.println("AnotherResource: " + value);
    }
}
