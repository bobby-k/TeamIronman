package com.telerikacademy.samples.treeSet;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
  final static String STRING_FORMAT = "yyyy-MM-dd HH:mm";
  final static String PRINT_FORMAT = "HH:mm dd MM yyyy";
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    SimpleDateFormat dateFormat=new SimpleDateFormat(STRING_FORMAT);
    //SimpleDateFormat df = new SimpleDateFormat(PRINT_FORMAT);
    Trip trip=new Trip("Vienna");
    
    for (int i = 0; i <3 ; i++) {
      System.out.println("Enter event name");
      String name=input.nextLine();
      System.out.println("Enter event start time  ");
      DateFormat formatter = new SimpleDateFormat(STRING_FORMAT);
      try {
        Date dateString = formatter.parse(input.nextLine());
        Event event =new Event(name,dateString);
        trip.addEvent(event);

      } catch (ParseException e) {
        System.out.println("Invalid date");
      }

    }
    Set set=trip.getListOfEvents().entrySet();
    Iterator<TreeMap>iterator=set.iterator();
    while(iterator.hasNext()){
      dateFormat.applyPattern(PRINT_FORMAT);
      Map.Entry me=(Map.Entry)iterator.next();
      System.out.println(dateFormat.format(me.getKey()));
      System.out.println(me.getValue());
    }


    
    
  }
  

  


}
