package com.telerikacademy.Menus;

import java.util.Scanner;

public class LoginMenu extends Menu {
    Scanner sc = new Scanner(System.in);


    @Override
    public void printMenu() {
        String[] options = {"Option 1: Login",
                "Option 2: Sign up",
                "Option 3: Exit",
                "Insert a digit to select menu option:"};

        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }

    }

    @Override
    public void selectOptions() {
        int option = 0;
        while (option <= 0 || option > 3) {
            printMenu();
            option = sc.nextInt();
        }
        switch (option) {
            case 1:
                //do something
                break;
            case 2:
                //do something
                break;
            case 3:
                //do something
                break;
            default:
                //ako ne izbere ot tezi
        }
    }

}


