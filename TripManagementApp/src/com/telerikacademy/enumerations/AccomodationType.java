package com.telerikacademy.enumerations;

public enum AccomodationType {
    HOTEL("Hotel"), HOSTEL("Hostel"), CAMP("Camp"), VILLA("Villa"), PRIVATE_RESIDENCE("Private residence");
    private final String name;

    AccomodationType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    }
