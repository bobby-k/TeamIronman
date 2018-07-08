package com.telerikacademy.enumerations;

public enum TripType {
    BUSSINESS("Business"), FAMILY("Family"), RELAX("Relax");
    private final String name;

    TripType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
