package com.telerikacademy.models;

import com.telerikacademy.exceptions.IncorrectInputException;
import com.telerikacademy.menus.LoginMenu;
import com.telerikacademy.menus.MainMenu;
import com.telerikacademy.users.User;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Application {

    private final static String DATE_FORMAT = "yyyy/MM/dd";
    private final static String TIME_FORMAT = "HH:mm yyyy/MM/dd";

    private Scanner input = new Scanner(System.in);
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern(TIME_FORMAT);
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

    //methods for LoginMenu
    //1
    public void logIn() throws ParseException {
        System.out.println("LOGIN");
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
                    new MainMenu(this).selectOptions();
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

    //2
    public void signUp() throws ParseException {
        System.out.println("Press ENTER to create new account. ");
        input.nextLine();
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

    //3
    public void logout() throws ParseException {
        System.out.println("Logout successful! ");
        System.out.println();
        currentUser = null;
        new LoginMenu(this).selectOptions();
    }

    //methods for MainMenu

    //1
    public void createNewTrip() throws ParseException {
        System.out.println("Press ENTER to create new trip. ");
        input.nextLine();
        System.out.println("Enter trip name: ");
        String tripName = input.nextLine();
        System.out.println("Enter destination: ");
        String destinaton = input.nextLine();
        System.out.printf("Enter start date in format %s: \n", DATE_FORMAT);
        String startDateString = input.nextLine();
        LocalDate startDate = LocalDate.parse(startDateString, dateFormat);
        System.out.printf("Enter end date in format %s: \n", DATE_FORMAT);
        String endDateString = input.nextLine();
        LocalDate endDate = LocalDate.parse(endDateString, dateFormat);
        System.out.println("Enter budget of the trip: ");
        double budget = input.nextDouble();
        System.out.println("Enter the number of the travelers: ");
        int travelers = input.nextInt();
        currentUser.getTrips().add(new Trip(tripName, destinaton, startDate,
                endDate, budget, travelers));
        System.out.println("Trip was successfully added. ");
        System.out.println();
    }

    //2
    public void clearTrips() {
        currentUser.getTrips().clear();
        System.out.println("Trips were successfully cleared. ");
        System.out.println();
    }
    
    //4
    public void viewLastCreatedTrip() {
        List<Trip> trips = new ArrayList<>(getCurrentUser().getTrips());
        Trip trip = trips.get(trips.size() - 1);
        System.out.printf("Name: %s\n" +
                "Destination: %s\n" +
                "Start: %s\n" +
                "End: %s\n" +
                "Budget: %.2f\n" +
                "Travelers: %d\n",
                trip.getTripName(),
                trip.getDestination(),
                trip.getStartDate().toString(),
                trip.getEndDate().toString(),
                trip.getBudget(),
                trip.getTravelers());
        System.out.println();
    }

    //5
    public void viewHistory() {
        List<Trip> printTrips = new ArrayList<>(getCurrentUser().getTrips());
        for (int i = 0; i < printTrips.size(); i++) {
            Trip trip = printTrips.get(i);
            System.out.printf("Trip name: %s\n" +
                            "Destination: %s\n" +
                            "Start: %s\n" +
                            "End: %s\n",
                    trip.getTripName(),
                    trip.getDestination(),
                    trip.getStartDate().toString(),
                    trip.getEndDate().toString());
            System.out.println();
        }
    }

    public void editTrip() {

    }
}