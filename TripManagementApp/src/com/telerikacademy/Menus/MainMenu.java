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
                "Option 2: Clear all trips",
                "Option 3: Edit last created trip",
                "Option 4: View last created trip",
                "Option 5: View History",
                "Option 6: Logout",
                "Option 7: Exit",
                "Insert a digit to select menu option: "};

        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
    }

    @Override
    public void selectOptions() throws ParseException {
        int option = 0;
        while (option <= 0 || option > 7) {
            printMenu();
            option = sc.nextInt();
        }
        switch (option) {
            case 1:
                getApp().createNewTrip();
                selectOptions();
                break;
            case 2:
                getApp().clearTrips();
                selectOptions();
                break;
            case 3:

                break;
            case 4:
                if (getApp().getCurrentUser().getTrips().isEmpty()) {
                    System.out.println("No trips were added. ");
                    System.out.println();
                } else {
                getApp().viewLastCreatedTrip();
                selectOptions();
                break;}
            case 5:
                getApp().viewHistory();
                selectOptions();
                break;
            case 6:
                getApp().logout();
                break;
            case 7:
                System.exit(0);
                break;
        }
    }
}