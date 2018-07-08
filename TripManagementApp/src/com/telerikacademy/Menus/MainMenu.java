package com.telerikacademy.menus;

import com.telerikacademy.models.Application;

import java.text.ParseException;
import java.util.Scanner;

public class MainMenu extends Menu {
    private Scanner sc = new Scanner(System.in);

    public MainMenu(Application app) {
        super(app);
    }


    @Override
    public void printMenu() {
        String[] options = {"Option 1: Create new trip",
                "Option 2: Edit trip",
                "Option 3: View trips",
                "Option 4: Logout",
                "Option 5: Exit",
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
            option = sc.nextInt();
        }
        switch (option) {
            case 1:
                getApp().addTrip();
                selectOptions();
                break;
            case 2:
                //do something in future
                break;
            case 3:
                getApp().viewTrips();
                selectOptions();
                break;
            case 4:
                getApp().logout();
                break;
            case 6:
                System.exit(0);
                break;

        }


    }
}


