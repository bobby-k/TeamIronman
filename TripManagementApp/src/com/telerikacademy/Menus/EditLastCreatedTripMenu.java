package com.telerikacademy.menus;

import com.telerikacademy.models.Application;
import java.text.ParseException;
import java.util.Scanner;

public class EditLastCreatedTripMenu extends Menu {
    Scanner scan = new Scanner(System.in);


    public EditLastCreatedTripMenu(Application app) {
        super(app);
    }

    @Override
    public void printMenu() {
        String[] options = {"Option 1: Change name",
                "Option 2: Change destination",
                "Option 3: Change start date",
                "Option 4: Change end date",
                "Option 5: Change budget",
                "Option 6: Change travelers",
                "Option 7: View trip activities",
                "Option 8: Back to main menu",
                "Insert a digit to select menu option: "};

        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
    }

    @Override
    public void selectOptions() throws ParseException {
        int option = 0;
        while (option <= 0 || option > 8) {
            printMenu();
            option = scan.nextInt();
        }

        switch (option) {
            case 1:
                getApp().changeName();
                selectOptions();
                break;
            case 2:
                getApp().changeDestination();
                selectOptions();
                break;
            case 3:
                getApp().changeStartDate();
                selectOptions();
                break;
            case 4:
                getApp().changeEndDate();
                selectOptions();
                break;
            case 5:
                getApp().changeBudget();
                selectOptions();
                break;
            case 6:
                getApp().changeTravelers();
                selectOptions();
                break;
            case 7:
                //TODO
                break;
            case 8:
                getApp().backToMainMenu();
                break;
        }
    }
}