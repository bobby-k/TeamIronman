package com.telerikacademy.models;

import com.telerikacademy.enumerations.LeisureActivityType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeisureAndFreeTimeActivity extends  TripActivity implements Attendable{
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

  public void setLeisureActivityType(LeisureActivityType leisureActivityType) {
    this.leisureActivityType = leisureActivityType;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public void printInfo() {

  }
}
