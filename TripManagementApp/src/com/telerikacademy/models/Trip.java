package com.telerikacademy.models;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.TreeMap;

public class Trip {

  private String tripName;
  private String destination;
  private LocalDate startDate;
  private LocalDate endDate;
  private double budget;
  private int travelers;
  private TreeMap<LocalDateTime, String> tripActivities;
  private long period;



  public Trip(String tripName,
              String destination,
              LocalDate startDate,
              LocalDate endDate,
              double budget,
              int travelers)
  {
    setTripName(tripName);
    setDestination(destination);
    setStartDate(startDate);
    setEndDate(endDate);
    setTripActivities(new TreeMap<LocalDateTime, String>());
    this.budget = budget;
    setTravelers(travelers);
    long period=ChronoUnit.DAYS.between(startDate,endDate);

  }

  public long getPeriod() {
    return period;
  }

  public void setPeriod(long period) {
    this.period = period;
  }

  public String getTripName() {
    return tripName;
  }

  private void setTripName(String tripName) {
    this.tripName = tripName;
  }

  public TreeMap<LocalDateTime, String> getTripActivities() {
    return tripActivities;
  }

  private void setTripActivities(TreeMap<LocalDateTime, String> tripActivities) {
    this.tripActivities = tripActivities;
  }




  public String getDestination() {
    return destination;
  }

  private void setDestination(String destination) {
    this.destination = destination;
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

  public double getBudget() {
    return budget;
  }

  public void setBudget(double budget) {
    this.budget = budget;
  }

  public int getTravelers() {
    return travelers;
  }

  private void setTravelers(int travelers) {
    this.travelers = travelers;
  }
}
