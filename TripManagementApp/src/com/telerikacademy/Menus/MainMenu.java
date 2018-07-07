package com.telerikacademy.menus;

import com.telerikacademy.models.Application;

import java.util.Scanner;

public class MainMenu extends Menu {
    Scanner sc = new Scanner(System.in);

    public MainMenu(Application app) {
        super(app);
    }


    @Override
    public void printMenu() {
        String[] options = {"Option 1: Create new trip",
                "Option 2: Edit current trip",
                "Option 3: View current trip",
                "Option 4: View history"};
    }

    @Override
    public void selectOptions() {
        int option = 0;
        while (option <= 0 || option > 4) {
            System.out.println("test");
            printMenu();
            option = sc.nextInt();
        }
        switch (option) {
            case 1:
                //do something in future
                break;
            case 2:
                //do something in future
                break;
            case 3:
                //do something in future
                break;
            case 4:
                //do something in future
                break;
            default:
                //ako ne izbere ot tezi

        }


    }
}


