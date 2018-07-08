package com.telerikacademy.models;

import com.telerikacademy.enumerations.TripType;
import com.telerikacademy.exceptions.IncorrectInputException;
import com.telerikacademy.menus.LoginMenu;
import com.telerikacademy.menus.MainMenu;
import com.telerikacademy.users.User;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Application {
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
    public void logIn() throws ParseException {
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

    public void signUp() throws ParseException {
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

    public void logout() throws ParseException {
        System.out.println("Logout successful! ");
        System.out.println();
        currentUser = null;
        new LoginMenu(this).selectOptions();
    }

    public void addTrip() throws ParseException {
        System.out.println("Enter trip name: ");
        String tripName = input.nextLine();
        System.out.println("Enter destination: ");
        String destinaton = input.nextLine();
        System.out.println("Enter trip type(Business, Family, Relax): ");
        String stringTripType = input.nextLine();
        TripType tripType = null;
        for(TripType tripType1 : TripType.values()){
            if(stringTripType.toLowerCase().equals(tripType1.toString().toLowerCase())){
                tripType = tripType1;
                break;
            }
        }
        System.out.println("Enter start date in format dd/MM/yyyy: ");
        String startDateString = input.nextLine();
        Date startDate = dateFormat.parse(startDateString);
        System.out.println("Enter end date in format dd/MM/yyyy: ");
        String endDateString = input.nextLine();
        Date endDate = dateFormat.parse(endDateString);
        System.out.println("Enter price of the trip: ");
        double price = input.nextDouble();
        System.out.println("Enter the number of the travelers: ");
        int travelers = input.nextInt();
        currentUser.getTrips().add(new Trip(tripName, destinaton,
                tripType, startDate, endDate, price,
                travelers));
    }

    public void viewTrips() {
        String result = "";
        for (int i = 0; i < currentUser.getTrips().size(); i++) {
            int index = i + 1;
            result += "Trip " + index + ": " + currentUser.getTrips().get(i).toString() +"\n";
        }
        System.out.println(result);
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

    }

    public void editTrip() {

    }

}
