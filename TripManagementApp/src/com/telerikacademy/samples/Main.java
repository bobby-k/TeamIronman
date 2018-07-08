package com.telerikacademy.samples;

import com.telerikacademy.models.Trip;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
  Scanner input = new Scanner(System.in);
  private final static String DATE_FORMAT = "yyyy/MM/dd";
  private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT);



  public void addTrip() throws InvalidDateFormatException {
    System.out.println("Enter trip name: ");
    String tripName = input.nextLine();
    System.out.println("Enter destination: ");
    String destinaton = input.nextLine();
    System.out.printf("Enter start date in format %s: \n", DATE_FORMAT);
    String startDateString = input.nextLine();
    LocalDate startDate = LocalDate.parse(startDateString, dateFormat);


    System.out.printf("Enter end date in format %s: \n", DATE_FORMAT);
    String endDateString = input.nextLine();
    LocalDate endDate = LocalDate.parse(endDateString, dateFormat);
    System.out.println("Enter budget of the trip: ");
    double budget = input.nextDouble();
    System.out.println("Enter the number of the travelers: ");
    int travelers = input.nextInt();

    System.out.println("Trip was successfully added. ");
    System.out.println();
  }
}
