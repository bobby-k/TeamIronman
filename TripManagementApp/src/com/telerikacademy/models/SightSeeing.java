package com.telerikacademy.models;

import java.time.LocalDate;

public class SightSeeing extends TripActivity implements Payable{


  public SightSeeing(String name, LocalDate startDate, LocalDate endDate) {
    super(name, startDate, endDate);
  }

  public SightSeeing(String name, LocalDate startDate, long period) {
    super(name, startDate, period);
  }

  @Override
  public void printInfo() {

  }

  @Override
  public void receivePaymentDetails() {

  }
}
