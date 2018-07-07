package com.telerikacademy.models;

import com.telerikacademy.exceptions.IncorrectInputException;
import com.telerikacademy.users.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    // TUK SE NAMIRAT GLAVNITE METODI
    //variables
    private Scanner input = new Scanner(System.in);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String name;
    private User currentUser;
    private List<User> users;

    //constructor
    public Application(String name) {
        setName(name);
        setCurrentUser(null);
        setUsers(new ArrayList<>());
    }

    //setters and getters
    public Scanner getInput() {
        return input;
    }

    private void setInput(Scanner input) {
        this.input = input;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    private void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    private void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public List<User> getUsers() {
        return users;
    }

    private void setUsers(List<User> users) {
        this.users = users;
    }

    //methods
    public void logIn() {
        System.out.println("Enter account: ");
        String account = input.nextLine();
        System.out.println("Enter password: ");
        String password = input.nextLine();
        boolean isCorrect = false;

        for (User user : users) {
            if (user.getAccount().equals(account)) {
                isCorrect = true;
                if (user.getPassword().equals(password)) {
                    currentUser = user;
                    System.out.println("Login successful. ");
                    System.out.println();
                    //new MainMenu TO DO
                    break;
                } else {
                    System.out.println("Incorrect password! ");
                    System.out.println();
                    break;
                }
            }
        }

        if (currentUser == null && !isCorrect) {
            System.out.println("This user is not existing! ");
            System.out.println();
            logIn();
        } else if (currentUser == null) {
            logIn();
        }
    }

    public void signUp() {
        System.out.println("Enter account: ");
        String account = input.nextLine();
        System.out.println("Enter password: ");
        String password = input.nextLine();
        System.out.println("Enter full name: ");
        String fullName = input.nextLine();
        System.out.println("Enter e-mail: ");
        String email = input.nextLine();
        boolean isAvailable = true;

        for (User user : users) {
            if (user.getAccount().equals(account)) {
                System.out.println("This account is already existing! ");
                System.out.println();
                isAvailable = false;
            }
        }
        if (isAvailable) {
            try {
                users.add(new User(account, password, fullName, email));
                System.out.println("Signup successful! ");
                System.out.println();
                logIn();
            } catch (IncorrectInputException e) {
                System.out.println(e.getMessage());
                signUp();
            }

        } else {
            signUp();
        }
    }

    public void logOut() {
        System.out.println("Logout successful! ");
        System.out.println();
        currentUser = null;
        //new LogInMenu TO DO
    }

    public void createTripActivity() throws ParseException {
        System.out.println("Enter Event name: ");
        String name = input.nextLine();
        System.out.println("Enter startDate: ");
        String startDate = input.nextLine();
        System.out.println("Enter endDate: ");
        String endDate = input.nextLine();
        //Event newEvent=new Event(name,dateFormat.parse(startDate),dateFormat.parse(endDate));
    }

    public void createTrip() throws ParseException {
        System.out.println("Enter Trip name: ");
        String name = input.nextLine();
        System.out.println("Enter trip start date in format dd/MM/yyyy: ");
        String startDate = input.nextLine();
        System.out.println("Enter trip's end date in format dd/MM/yyyy: ");
        String endDate = input.nextLine();
        Trip trip = new Trip(name, dateFormat.parse(startDate), dateFormat.parse(endDate));
    }

    public void editTrip() {

    }

}
