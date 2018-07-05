package com.telerikacademy.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public abstract class TripActivity {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private long period;

    //long period=ChronoUnit.DAYS.between(dateTwo,dateOne);


    public TripActivity(String name) {
      setName(name);
    }

    public TripActivity(String name, LocalDateTime startDate, LocalDateTime endDate){
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

    public LocalDateTime getStartDate() {
      return startDate;
    }

    private void setStartDate(LocalDateTime startDate) {
      this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
      return endDate;
    }

    private void setEndDate(LocalDateTime endDate) {
      this.endDate = endDate;
    }
    //Кой метод да override-vame????
    public abstract void getNotification();
    public abstract void printInfo();

  }

