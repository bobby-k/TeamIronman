package com.telerikacademy.enumerations;

public enum TransportationType {
    AIRPLANE("Airplane"), TRAIN("Train"), BUS("Bus"), CRUISE("Cruise"), CAR("Car"), OTHER("Other");

    private final String name;

    TransportationType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
