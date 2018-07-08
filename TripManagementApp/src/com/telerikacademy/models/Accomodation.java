package com.telerikacademy.models;


import com.telerikacademy.enumerations.AccomodationType;
import com.telerikacademy.interfaces.AlternativeRouteviewable;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Accomodation extends TripActivity implements AlternativeRouteviewable {
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
    System.out.printf("Start: %s\n", this.getStartTime());
    System.out.printf("End: %s\n", this.getEndTime());
    System.out.printf("Period: %s\n", this.getPeriod());
    System.out.printf("Name: %s\n", this.getName());
    System.out.printf("Location: %s\n", this.getLocation());
    System.out.printf("Address: %s\n", this.getAddress());
    System.out.printf("Price: %s\n", this.getPrice());
    System.out.printf("Accomodation Type: %s\n", this.getAccomodationType());
  }



  @Override
  public void viewAlternativeRoute() {
    System.out.printf("You will be redirected to alternative route to your %s %s\n",
        getAccomodationType().toString().toLowerCase(), getAddress());
  }
}
