package com.telerikacademy.models;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class TripActivity {
  private String name;
  private LocalDateTime startTime;
  private LocalDateTime endTime;
  //period in hours
  private long period;

  //long period=ChronoUnit.DAYS.between(dateTwo,dateOne);

  public TripActivity(String name, LocalDateTime startDate, LocalDateTime endDate) {
    setName(name);
    setStartTime(startDate);
    setEndTime(endDate);
    setPeriod(ChronoUnit.HOURS.between(startDate,endDate));
  }


  public String getName() {
    return name;
  }

  private void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  private void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  private void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public long getPeriod() {
    return period;
  }

  protected void setPeriod(long period) {
    this.period = period;
  }
  //public abstract void getNotification();

  public abstract void printInfo();

}

