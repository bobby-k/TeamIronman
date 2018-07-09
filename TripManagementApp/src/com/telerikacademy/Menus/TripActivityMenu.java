package com.telerikacademy.menus;

import com.telerikacademy.models.Application;

import java.text.ParseException;
import java.util.Scanner;

public class TripActivityMenu extends Menu {
    private Scanner scan = new Scanner(System.in);

    public TripActivityMenu(Application app) {
        super(app);
    }

    @Override
    public void printMenu() {
        String[] options = {"Option 1: Add accomodation to last trip",
                "Option 2: Add free time activity to last trip",
                "Option 3: Add sightseeing to last trip",
                "Option 4: Add transportation to last trip",
                "Option 5: View activities from last trip",
                "Option 6: Back to edit menu",
                "Insert a digit to select menu option: "};

        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
    }

    @Override
    public void selectOptions() throws ParseException {
        int option = 0;
        while (option <= 0 || option > 6) {
            printMenu();
            option = scan.nextInt();
        }

        switch (option) {
            case 1:
                getApp().addAccomodationToLastTrip();
                selectOptions();
                break;
            case 2:
                getApp().addFreeTimeActivityToLastTrip();
                selectOptions();
                break;
            case 3:
                getApp().addSightSeeingToLastTrip();
                selectOptions();
                break;
            case 4:
                getApp().addTransportationToLastTrip();
                selectOptions();
                break;

            case 5:


                break;
            case 6:
                getApp().goToEditLastTripMenu();
        }
    }
}
