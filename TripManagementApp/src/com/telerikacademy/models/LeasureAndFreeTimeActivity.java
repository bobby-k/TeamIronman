package com.telerikacademy.models;

import java.time.LocalDate;

public class LeasureAndFreeTimeActivity extends  TripActivity implements Attendable{
  private LeisureActivityType leisureActivityType;

  public LeasureAndFreeTimeActivity(String name, LocalDate startDate, LocalDate endDate) {
    super(name, startDate, endDate);
  }

  public LeasureAndFreeTimeActivity(String name, LocalDate startDate, long period) {
    super(name, startDate, period);
  }



  @Override
  public void printInfo() {

  }
}
