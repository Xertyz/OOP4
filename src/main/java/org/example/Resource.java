package org.example;

public class Resource implements Printer {

    protected int id;
    protected int value;

    public Resource() {
    }

    public Resource(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void printInfo() {
        System.out.println("ID " + this.id + ", value " + this.value);
    }
}
