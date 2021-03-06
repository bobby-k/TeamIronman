package com.telerikacademy.enumerations;

public enum LeisureActivityType {
    BARS("Bars"), PARKS("Parks"), GARDEN("Garden"), SPORTS("Sports"), SHOPPING("Shopping");
    private final String name;

    LeisureActivityType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
