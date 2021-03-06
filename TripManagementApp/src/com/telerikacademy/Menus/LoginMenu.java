package com.telerikacademy.menus;

import com.telerikacademy.models.Application;

import java.text.ParseException;
import java.util.Scanner;

public class LoginMenu extends Menu {
    private Scanner sc = new Scanner(System.in);

    public LoginMenu(Application app) {
        super(app);
    }

    @Override
    public void printMenu() {
        String[] options = {"Option 1: Login",
                "Option 2: Sign up",
                "Option 3: Exit",
                "Insert a digit to select menu option: "};

        for (int i = 0; i < options.length; i++) {
            System.out.println(options[i]);
        }
    }

    @Override
    public void selectOptions() throws ParseException {
        int option = 0;
        while (option <= 0 || option > 3) {
            printMenu();
            option = sc.nextInt();
        }
        switch (option) {
            case 1:
                getApp().logIn();
                break;
            case 2:
                getApp().signUp();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}