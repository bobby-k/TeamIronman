package com.telerikacademy.enumerations;

public enum SightSeeingType {
    LANDMARK("Landmark"), MUSEUM("Museum"), GALLERY("Gallery"), CASTLE("Castle");

    private final String name;

    SightSeeingType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
