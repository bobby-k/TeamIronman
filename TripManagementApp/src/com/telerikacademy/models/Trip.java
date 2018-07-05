package com.telerikacademy.models;


import java.util.ArrayList;
import java.util.Date;

public class Trip {

  private String tripName;
  private ArrayList<String> destinations;
  private TripType tripType;
  private Date startDate;
  private Date endDate;
  private Budget budget;

  public ArrayList<String> getDestinations() {
    return destinations;
  }

  public void setDestinations(ArrayList<String> destinations) {
    this.destinations = destinations;
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

  public Budget getBudget() {
    return budget;
  }

  public void setBudget(Budget budget) {
    this.budget = budget;
  }



  public Date getTripStart() {
    return tripStart;
  }

  public void setTripStart(Date tripStart) {
    this.tripStart = tripStart;
  }

  public Date getTripEnd() {
    return tripEnd;
  }

  public void setTripEnd(Date tripEnd) {
    this.tripEnd = tripEnd;
  }

  private Date tripStart;
  private Date tripEnd;
  private ArrayList<Event> eventsList;
  //SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");


  public Trip(String tripName,Date tripStart,Date tripEnd) {
    setTripName(tripName);
    setTripStart(tripStart);
    setTripEnd(tripEnd);
    setEventsList(new ArrayList<>());
  }

  public String getTripName() {
    return tripName;
  }

  public void setTripName(String tripName) {
    this.tripName = tripName;
  }

  public ArrayList<Event> getEventsList() {
    return eventsList;
  }

  public void setEventsList(ArrayList<Event> eventsList) {
    this.eventsList = eventsList;
  }





}
