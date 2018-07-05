package com.telerikacademy.models;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public abstract class TripActivity {
  private String name;
  private LocalDate startDate;
  private LocalDate endDate;
  //period in days
  private long period;

  //long period=ChronoUnit.DAYS.between(dateTwo,dateOne);

  public TripActivity(String name, LocalDate startDate, LocalDate endDate) {
    setName(name);
    setStartDate(startDate);
    setEndDate(endDate);
    setPeriod(ChronoUnit.DAYS.between(startDate, endDate));
  }

  public TripActivity(String name, LocalDate startDate, long period) {
    this(name, startDate, startDate.plusDays(period));
    setPeriod(period);
  }

  public String getName() {
    return name;
  }

  private void setName(String name) {
    this.name = name;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  private void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  private void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public long getPeriod() {
    return period;
  }

  public void setPeriod(long period) {
    this.period = period;
  }
  //public abstract void getNotification();

  public abstract void printInfo();

}

