package com.telerikacademy.samples.treeSet;

import java.util.Date;

public class Event {
  private String name;
  private Date start;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getStart() {
    return start;
  }

  public void setStart(Date start) {
    this.start = start;
  }

  public Event(String name, Date start) {
    this.name = name;
    this.start = start;
  }
}
