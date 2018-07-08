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

  public void setStartLocation(String startLocation) {
    this.startLocation = startLocation;
  }

  public String getEndLocation() {
    return endLocation;
  }

  public void setEndLocation(String endLocation) {
    this.endLocation = endLocation;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  public double getDuration() {
    return duration;
  }

  public void setDuration(double duration) {
    this.duration = duration;
  }

  public double getTicketPrice() {
    return ticketPrice;
  }

  public void setTicketPrice(double ticketPrice) {
    this.ticketPrice = ticketPrice;
  }

  @Override
  public void printInfo() {

  }
}
