package org.example;

public class ResConsumption extends Resource implements Printer {

    public ResConsumption(int id, int value) {
        super(id, value);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void printInfo() {
        System.out.println("Op " + this.id + " - Consum: " + this.value);
    }
}
