package com.telerikacademy.models;

import com.telerikacademy.enumerations.LeisureActivityType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeisureAndFreeTimeActivity extends  TripActivity {
  private LeisureActivityType leisureActivityType;
  private double price;

  public LeisureAndFreeTimeActivity(String name,
                                    LocalDateTime startDate,
                                    LocalDateTime endDate,
                                    double price,
                                    LeisureActivityType leisureActivityType) {
    super(name, startDate, endDate);
    setLeisureActivityType(leisureActivityType);
    setPrice(price);
  }


  public LeisureActivityType getLeisureActivityType() {
    return leisureActivityType;
  }

  private void setLeisureActivityType(LeisureActivityType leisureActivityType) {
    this.leisureActivityType = leisureActivityType;
  }

  public double getPrice() {
    return price;
  }

  private void setPrice(double price) {
    this.price = price;
  }

  @Override
  public void printInfo() {
    System.out.printf("Start: %s\n", this.getStartTime());
    System.out.printf("End: %s\n", this.getEndTime());
    System.out.printf("Period: %s\n", this.getPeriod());
    System.out.printf("Name: %s\n", this.getName());
    System.out.printf("Leisure Activity Type: %s\n", this.getLeisureActivityType());
    System.out.printf("Price: %s\n", this.getPrice());
  }
}
