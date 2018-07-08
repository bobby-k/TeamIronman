package com.telerikacademy.models;


import com.telerikacademy.enumerations.TripType;

import java.util.ArrayList;
import java.util.Date;

public class Trip {

  private String tripName;
  private String destination;
  private TripType tripType;
  private Date startDate;
  private Date endDate;
  private double price;
  private Date tripStart;
  private Date tripEnd;
  private ArrayList<TripActivity> eventsList;
  //SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");

  public TripType getTripType() {
    return tripType;
  }

  public void setTripType(TripType tripType) {
    this.tripType = tripType;
  }

  public int getTravelers() {
    return travelers;
  }

  public void setTravelers(int travelers) {
    this.travelers = travelers;
  }

  private int travelers;

  public String getDestinations() {
    return destination;
  }

  public void setDestinations(String destinations) {
    this.destination = destinations;
  }


  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Date getTripStart() {
    return tripStart;
  }

  private void setTripStart(Date tripStart) {
    this.tripStart = tripStart;
  }

  public Date getTripEnd() {
    return tripEnd;
  }

  private void setTripEnd(Date tripEnd) {
    this.tripEnd = tripEnd;
  }




  public Trip(String tripName,Date tripStart,Date tripEnd) {
    setTripName(tripName);
    setTripStart(tripStart);
    setTripEnd(tripEnd);
    setEventsList(new ArrayList<>());
  }

  public Trip(String tripName, String destination, TripType tripType, Date startDate, Date endDate, double price, int travelers) {
    this.tripName = tripName;
    this.destination = destination;
    this.tripType = tripType;
    this.startDate = startDate;
    this.endDate = endDate;
    this.price = price;
    this.travelers = travelers;
  }

  public String getTripName() {
    return tripName;
  }

  private void setTripName(String tripName) {
    this.tripName = tripName;
  }

  public ArrayList<TripActivity> getEventsList() {
    return eventsList;
  }

  private void setEventsList(ArrayList<TripActivity> eventsList) {
    this.eventsList = eventsList;
  }





}
