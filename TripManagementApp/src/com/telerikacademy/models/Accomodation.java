package com.telerikacademy.models;

import com.telerikacademy.enumerations.AccomodationType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Accomodation extends TripActivity implements Reservable {
  private String location;
  private String address;
  private double price;
  private AccomodationType accomodationType;

  public Accomodation(String name,
                      String location,
                      AccomodationType accomodationType,
                      LocalDateTime startDate,
                      LocalDateTime endDate,
                      String address,
                      double price) {
    super(name, startDate, endDate);
    setAccomodationType(accomodationType);
    setLocation(location);
    setAddress(address);
    setPrice(price);
    setPeriod(ChronoUnit.HOURS.between(startDate, endDate));

  }


  public String getLocation() {
    return location;
  }

  private void setLocation(String location) {
    this.location = location;
  }

  public String getAddress() {
    return address;
  }

  private void setAddress(String address) {
    this.address = address;
  }

  public double getPrice() {
    return price;
  }

  private void setPrice(double price) {
    this.price = price;
  }

  public AccomodationType getAccomodationType() {
    return accomodationType;
  }

  private void setAccomodationType(AccomodationType accomodationType) {
    this.accomodationType = accomodationType;
  }

  @Override
  public void printInfo() {

  }

  @Override
  public void addReservationDetails() {

  }


}
