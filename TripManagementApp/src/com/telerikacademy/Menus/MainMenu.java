package com.telerikacademy.Menus;

import java.util.Scanner;

public class MainMenu extends Menu {
    Scanner sc = new Scanner(System.in);


    @Override
    public void printMenu() {
        String[] options = {"Create new trip",
                "Edit current trip",
                "View current trip",
                "View history"};
    }

    @Override
    public void selectOptions() {
        int option = 0;
        while (option <= 0 || option > 4) {
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

