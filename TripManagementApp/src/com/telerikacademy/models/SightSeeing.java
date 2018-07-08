package com.telerikacademy.models;

import com.telerikacademy.enumerations.SightSeeingType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SightSeeing extends TripActivity implements Payable {
  private String address;
  private SightSeeingType sightSeeingType;
  private double ticketPrice;

  public SightSeeing(String name,
                     String address,
                     SightSeeingType sightSeeingType,
                     LocalDateTime startDate,
                     LocalDateTime endDate,
                     double ticketPrice) {
    super(name, startDate, endDate);

  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public SightSeeingType getSightSeeingType() {
    return sightSeeingType;
  }

  public void setSightSeeingType(SightSeeingType sightSeeingType) {
    this.sightSeeingType = sightSeeingType;
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

  @Override
  public void receivePaymentDetails() {

  }
}
