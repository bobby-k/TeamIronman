package com.telerikacademy.models;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.TreeMap;

public class Trip {

  private String tripName;
  private ArrayList<String> destinations;
  private LocalDate startDate;
  private LocalDate endDate;
  private double budget;
  private TreeMap<LocalDateTime, String> tripActivities;
  private long period;


  public Trip(String tripName, LocalDate startDate, LocalDate endDate) {
    this(tripName,startDate,endDate,0);

  }
  public Trip(String tripName, LocalDate startDate, long period) {
    this(tripName,startDate,period,0);
  }

  public Trip(String tripName,
              LocalDate startDate,
              long period,
              double budget) {
    setTripName(tripName);
    setStartDate(startDate);
    setPeriod(period);
    setEndDate(startDate.plusDays(period));
    setTripActivities(new TreeMap<LocalDateTime, String>());
    setDestinations(new ArrayList<>());
    this.budget = budget;

  }
  public Trip(String tripName,
              LocalDate startDate,
              LocalDate endDate,
              double budget) {
    setTripName(tripName);
    setStartDate(startDate);
    setStartDate(startDate);
    setEndDate(endDate);
    long period=ChronoUnit.DAYS.between(startDate,endDate);
    setDestinations(new ArrayList<>());
    setTripActivities(new TreeMap<LocalDateTime, String>());
    this.budget = budget;

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

  public void setTripName(String tripName) {
    this.tripName = tripName;
  }

  public TreeMap<LocalDateTime, String> getTripActivities() {
    return tripActivities;
  }

  public void setTripActivities(TreeMap<LocalDateTime, String> tripActivities) {
    this.tripActivities = tripActivities;
  }


  private int travelers;

  public ArrayList<String> getDestinations() {
    return destinations;
  }

  public void setDestinations(ArrayList<String> destinations) {
    this.destinations = destinations;
  }


  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
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














}
