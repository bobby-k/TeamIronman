package com.telerikacademy.models;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import com.telerikacademy.enumerations.AccomodationType;
import com.telerikacademy.enumerations.LeisureActivityType;
import com.telerikacademy.enumerations.SightSeeingType;
import com.telerikacademy.enumerations.TransportationType;
import com.telerikacademy.exceptions.IncorrectInputException;
import com.telerikacademy.menus.EditLastCreatedTripMenu;
import com.telerikacademy.menus.LoginMenu;
import com.telerikacademy.menus.MainMenu;
import com.telerikacademy.menus.TripActivityMenu;
import com.telerikacademy.users.User;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    //3
    public void goToEditLastTripMenu() throws ParseException {
        System.out.println();
        new EditLastCreatedTripMenu(this).selectOptions();
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

    //method for EditLastCreatedTrip
    //1
    public void changeName() {
        System.out.println("Enter new name: ");
        String newName = input.nextLine();
        List<Trip> trips = new ArrayList<>(getCurrentUser().getTrips());
        Trip lastTrip = trips.get(trips.size() - 1);
        lastTrip.setTripName(newName);
    }

    //2
    public void changeDestination() {
        System.out.println("Enter new destination: ");
        String newDestination = input.nextLine();
        List<Trip> trips = new ArrayList<>(getCurrentUser().getTrips());
        Trip lastTrip = trips.get(trips.size() - 1);
        lastTrip.setDestination(newDestination);
    }

    //3
    public void changeStartDate() {
        System.out.printf("Enter new start date in format %s: \n", DATE_FORMAT);
        input.nextLine();
        String newStartDate = input.nextLine();
        LocalDate newStartLocalDate = LocalDate.parse(newStartDate, dateFormat);
        List<Trip> trips = new ArrayList<>(getCurrentUser().getTrips());
        Trip lastTrip = trips.get(trips.size() - 1);
        lastTrip.setStartDate(newStartLocalDate);
    }

    //4
    public void changeEndDate() {
        System.out.printf("Enter new end date in format %s: \n", DATE_FORMAT);
        input.nextLine();
        String newEndDate = input.nextLine();
        LocalDate newEndLocalDate = LocalDate.parse(newEndDate, dateFormat);
        List<Trip> trips = new ArrayList<>(getCurrentUser().getTrips());
        Trip lastTrip = trips.get(trips.size() - 1);
        lastTrip.setEndDate(newEndLocalDate);
    }

    //5
    public void changeBudget() {
        System.out.println("Enter new budget: ");
        double newBudget = input.nextDouble();
        List<Trip> trips = new ArrayList<>(getCurrentUser().getTrips());
        Trip lastTrip = trips.get(trips.size() - 1);
        lastTrip.setBudget(newBudget);
    }

    //6
    public void changeTravelers() {
        System.out.println("Enter new travelers: ");
        int newTravelers = input.nextInt();
        List<Trip> trips = new ArrayList<>(getCurrentUser().getTrips());
        Trip lastTrip = trips.get(trips.size() - 1);
        lastTrip.setTravelers(newTravelers);
    }

    //7
    public void goToTripActivityMenu() throws ParseException {
        System.out.println();
        new TripActivityMenu(this).selectOptions();
    }

    //8
    public void backToMainMenu() throws ParseException {
        System.out.println();
        new MainMenu(this).selectOptions();
    }

    //methods for TripActivityMenu
    //1
    public void addAccomodationToLastTrip() {
        input.nextLine();
        System.out.println("Enter accomodation name: ");
        String name = input.nextLine();
        System.out.println("Enter accomodation location: ");
        String location = input.nextLine();
        System.out.println("Enter accomodation type(Hotel , Hostel, Camp, VIilla, Private residence): ");
        String newAccomodationType = input.nextLine();
        AccomodationType type = null;
        for (AccomodationType accomodationType : AccomodationType.values()) {
            if (newAccomodationType.toLowerCase().equals(accomodationType.toString().toLowerCase())) {
                type = accomodationType;
                break;
            }
        }
        System.out.printf("Enter accomodation start date in format %s: ", TIME_FORMAT);
        String startDateInput = input.nextLine();
        LocalDateTime startDate = LocalDateTime.parse(startDateInput, timeFormat);
        System.out.printf("Enter accomodation end date in format %s: ", TIME_FORMAT);
        String endDateInput = input.nextLine();
        LocalDateTime endDate = LocalDateTime.parse(endDateInput, timeFormat);
        System.out.println("Enter accomodation adress: ");
        String address = input.nextLine();
        System.out.println("Enter accomodation price: ");
        double price = input.nextDouble();
        currentUser.getTripActivities().put(startDate, new Accomodation(name, location, type,
                startDate, endDate, address, price));
    }

    //2
    public void addFreeTimeActivityToLastTrip() {
        input.nextLine();
        System.out.println("Enter free time activity name: ");
        String name = input.nextLine();
        System.out.printf("Enter free time activity start date in format %s: ", TIME_FORMAT);
        String startDateInput = input.nextLine();
        LocalDateTime startDate = LocalDateTime.parse(startDateInput, timeFormat);
        System.out.printf("Enter free time activity end date in format %s: ", TIME_FORMAT);
        String endDateInput = input.nextLine();
        LocalDateTime endDate = LocalDateTime.parse(endDateInput, timeFormat);
        System.out.println("Enter free time activity price: ");
        double price = input.nextDouble();
        System.out.println("Enter free time activity type(Bars, Parks, Garden, Sports, Shopping): ");
        String newLeisureType = input.nextLine();
        LeisureActivityType type = null;
        for (LeisureActivityType leisureType : LeisureActivityType.values()) {
            if (newLeisureType.toLowerCase().equals(leisureType.toString().toLowerCase())) {
                type = leisureType;
                break;
            }
        }
        currentUser.getTripActivities().put(startDate, new LeisureAndFreeTimeActivity(name, startDate, endDate, price, type));
    }

    //3
    public void addSightSeeingToLastTrip() {
        input.nextLine();
        System.out.println("Enter sightseeing name: ");
        String name = input.nextLine();
        System.out.println("Enter sightseeing address: ");
        String address = input.nextLine();
        System.out.println("Enter sightseeing type(Landmarks, Museum, Gallery, Castle): ");
        String newSightseeingType = input.nextLine();
        SightSeeingType type = null;
        for (SightSeeingType sightType : SightSeeingType.values()) {
            if (newSightseeingType.toLowerCase().equals(sightType.toString().toLowerCase())) {
                type = sightType;
                break;
            }
        }
        System.out.printf("Enter sightseeing start date in format %s: ", TIME_FORMAT);
        String startDateInput = input.nextLine();
        LocalDateTime startDate = LocalDateTime.parse(startDateInput, timeFormat);
        System.out.printf("Enter sightseeing end date in format %s: ", TIME_FORMAT);
        String endDateInput = input.nextLine();
        LocalDateTime endDate = LocalDateTime.parse(endDateInput, timeFormat);
        System.out.println("Enter ticket price: ");
        double ticketPrice = input.nextDouble();
        currentUser.getTripActivities().put(startDate, new SightSeeing(name, address, type, startDate, endDate, ticketPrice));
    }

    //4
    public void addTransportationToLastTrip() {
        input.nextLine();
        System.out.println("Enter transportation name: ");
        String name = input.nextLine();
        System.out.printf("Enter transportation start date in format %s: ", TIME_FORMAT);
        String startDateInput = input.nextLine();
        LocalDateTime startDate = LocalDateTime.parse(startDateInput, timeFormat);
        System.out.printf("Enter transportation end date in format %s: ", TIME_FORMAT);
        String endDateInput = input.nextLine();
        LocalDateTime endDate = LocalDateTime.parse(endDateInput, timeFormat);
        System.out.println("Enter transportation type(Airplane, Train, Bus, Cruise, Car, Other): ");
        String newTransportationType = input.nextLine();
        TransportationType type = null;
        for (TransportationType transportType : TransportationType.values()) {
            if (newTransportationType.toLowerCase().equals(transportType.toString().toLowerCase())) {
                type = transportType;
                break;
            }
        }
        System.out.println("Enter start location: ");
        String startLocation = input.nextLine();
        System.out.println("Enter end location: ");
        String endLocation = input.nextLine();
        System.out.println("Enter distance: ");
        double distance = input.nextDouble();
        double ticketPrice = input.nextDouble();
        currentUser.getTripActivities().put(startDate, new Transportation(name, startDate, endDate, type,
                startLocation, endLocation, distance, ticketPrice));
    }

    //5
    //todo
    public void viewActivitiesFromLastTrip() {
        TreeMap<LocalDateTime, TripActivity> printActivities = new TreeMap<>(currentUser.getTripActivities());

    }

    //6
    public void backToEditMenu() throws ParseException {
        System.out.println();
        new EditLastCreatedTripMenu(this).selectOptions();
    }
}