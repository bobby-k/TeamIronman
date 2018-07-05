package com.telerikacademy.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public abstract class TripActivity {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private long period;

  public long getPeriod() {
    return period;
  }

  public void setPeriod(long period) {
    this.period = period;
  }



    //long period=ChronoUnit.DAYS.between(dateTwo,dateOne);


    public TripActivity(String name) {
      setName(name);
    }

    public TripActivity(String name, LocalDate startDate, LocalDate endDate){
      setName(name);
      setStartDate(startDate);
      setEndDate(endDate);
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
    //Кой метод да override-vame????
    public abstract void getNotification();
    public abstract void printInfo();

  }

