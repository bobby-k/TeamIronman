package com.telerikacademy.samples.treeSet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Exc {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    final String STRING_FORMAT = "yyyy-MM-dd HH:mm";
    //final String NEW_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    DateFormat formatter = new SimpleDateFormat(STRING_FORMAT);

    try {
      Date dateString = formatter.parse(input.nextLine());
      //((SimpleDateFormat) formatter).applyPattern(NEW_FORMAT);
      System.out.println(formatter.format(dateString));

    } catch (ParseException e) {
      System.out.println("Invalid date");
    }


  }
}
