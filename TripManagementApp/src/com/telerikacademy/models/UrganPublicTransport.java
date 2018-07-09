package com.telerikacademy.models;

import com.telerikacademy.enumerations.TransportationType;

import java.time.LocalDateTime;

public class UrganPublicTransport extends Transportation {
    private String lineNumber;
    private double distanceWalkingToStation;
    private double distanceWalkingToDestination;


    public UrganPublicTransport(String name,
                                LocalDateTime startDate,
                                LocalDateTime endDate,
                                TransportationType transportType,
                                String startLocation,
                                String endLocation,
                                double distance,
                                double ticketPrice,
                                String lineNumber,
                                double distanceWalkingToDestination,
                                double distanceWalkingToStation) {
        super(name, startDate, endDate,
                transportType, startLocation, endLocation, distance, ticketPrice);
        setLineNumber(lineNumber);
        setDistanceWalkingToDestination(distanceWalkingToDestination);
        setDistanceWalkingToStation(distanceWalkingToStation);
    }

    public String getLineNumber() {
        return lineNumber;
    }

    private void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public double getDistanceWalkingToStation() {
        return distanceWalkingToStation;
    }

    private void setDistanceWalkingToStation(double distanceWalkingToStation) {
        this.distanceWalkingToStation = distanceWalkingToStation;
    }

    public double getDistanceWalkingToDestination() {
        return distanceWalkingToDestination;
    }

    private void setDistanceWalkingToDestination(double distanceWalkingToDestination) {
        this.distanceWalkingToDestination = distanceWalkingToDestination;
    }

    @Override
    public void printInfo() {

    }
}
