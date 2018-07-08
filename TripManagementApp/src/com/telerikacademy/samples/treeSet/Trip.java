package com.telerikacademy.samples.treeSet;

import java.util.Date;
import java.util.TreeMap;

public class Trip {
  private String name;
  private TreeMap<Date, String> listOfEvents;

  public Trip(String name) {
    this.name = name;
    this.listOfEvents = new TreeMap<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TreeMap<Date, String> getListOfEvents() {
    return listOfEvents;
  }

  public void setListOfEvents(TreeMap<Date, String> listOfEvents) {
    this.listOfEvents = listOfEvents;
  }

  public String addDetail(Event event) {
    return String.format("%s with address %s",event.getName(),getName());
  }

  public void addEvent(Event event) {
    listOfEvents.put(event.getStart(),addDetail(event));
  }
}
