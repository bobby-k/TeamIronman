package com.telerikacademy.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Application {
  // TUK SE NAMIRAT GLAVNITE METODI
  Scanner input = new Scanner(System.in);
  SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");

  void createTripActivity() throws ParseException {
    System.out.println("Enter Event name");
    String name=input.nextLine();
    System.out.println("Enter startDate");
    String startDate=input.nextLine();
    System.out.println("Enter endDate");
    String endDate=input.nextLine();
    //Event newEvent=new Event(name,dateFormat.parse(startDate),dateFormat.parse(endDate));
  }
  void createTrip() throws ParseException {
    System.out.println("Enter Trip name");
    String name=input.nextLine();
    System.out.println("Enter trip start date in format dd/MM/yyyy");
    String startDate=input.nextLine();
    System.out.println("Enter trip's end date in format dd/MM/yyyy");
    String endDate=input.nextLine();
   Trip trip=new Trip(name,dateFormat.parse(startDate),dateFormat.parse(endDate));
  }
  void editTrip(){

  }

  void logIn(){

  }
}
