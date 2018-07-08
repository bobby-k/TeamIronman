package com.telerikacademy.models;

import com.telerikacademy.enumerations.VehicleType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Transportation extends TripActivity {
  private VehicleType transportType;
  private String startLocation;
  private String endLocation;
  private double distance;
  private double duration;
  private double ticketPrice;


  public Transportation(String name,
                        LocalDateTime startDate,
                        LocalDateTime endDate,
                        VehicleType transportType,
                        String startLocation,
                        String endLocation,
                        double distance,
                        double ticketPrice)
  {
    super(name, startDate, endDate);
    setDistance(distance);
    setDuration(ChronoUnit.MINUTES.between(startDate,endDate));
    setDistance(distance);
    setEndLocation(endLocation);
    setStartLocation(startLocation);
    setTicketPrice(ticketPrice);
  }

  public VehicleType getTransportType() {
    return transportType;
  }

  public void setTransportType(VehicleType transportType) {
    this.transportType = transportType;
  }

  public String getStartLocation() {
    return startLocation;
  }

  private void setStartLocation(String startLocation) {
    this.startLocation = startLocation;
  }

  public String getEndLocation() {
    return endLocation;
  }

  private void setEndLocation(String endLocation) {
    this.endLocation = endLocation;
  }

  public double getDistance() {
    return distance;
  }

  private void setDistance(double distance) {
    this.distance = distance;
  }

  public double getDuration() {
    return duration;
  }

  private void setDuration(double duration) {
    this.duration = duration;
  }

  public double getTicketPrice() {
    return ticketPrice;
  }

  private void setTicketPrice(double ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  @Override
  public void printInfo() {
    System.out.printf("Start: %s\n", this.getStartTime());
    System.out.printf("End: %s\n", this.getEndTime());
    System.out.printf("From: %s\n", this.getStartLocation());
    System.out.printf("To: %s\n", this.getEndLocation());
    System.out.printf("Name: %s\n", this.getName());
    System.out.printf("Distance: %s\n", this.getDistance());
    System.out.printf("Duration: %s\n", this.getDuration());
    System.out.printf("Period: %s\n", this.getPeriod());
    System.out.printf("Transport Type: %s\n", this.transportType);
    System.out.printf("Ticket Price: %s\n", this.getTicketPrice());


  }
}
