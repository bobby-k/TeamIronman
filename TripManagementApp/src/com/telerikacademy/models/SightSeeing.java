package com.telerikacademy.models;

import com.telerikacademy.enumerations.SightSeeingType;
import com.telerikacademy.interfaces.AlternativeRouteviewable;
import com.telerikacademy.interfaces.OnlinePayable;

import java.time.LocalDateTime;

public class SightSeeing extends TripActivity implements OnlinePayable, AlternativeRouteviewable {
    private String address;
    private SightSeeingType sightSeeingType;
    private double ticketPrice;

    public SightSeeing(String name,
                       String address,
                       SightSeeingType sightSeeingType,
                       LocalDateTime startDate,
                       LocalDateTime endDate,
                       double ticketPrice) {
        super(name, startDate, endDate);

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SightSeeingType getSightSeeingType() {
        return sightSeeingType;
    }

    public void setSightSeeingType(SightSeeingType sightSeeingType) {
        this.sightSeeingType = sightSeeingType;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }


    @Override
    public void printInfo() {
        System.out.printf("Start: %s\n", this.getStartTime());
        System.out.printf("End: %s\n", this.getEndTime());
        System.out.printf("Period: %s\n", this.getPeriod());
        System.out.printf("Name: %s\n", this.getName());
        System.out.printf("Address: %s\n", this.getAddress());
        System.out.printf("Ticket Price: %s\n", this.getTicketPrice());
        System.out.printf("Sightseeing Type: %s\n", this.getSightSeeingType());


    }

    @Override
    public void receivePaymentDetails() {
        System.out.printf("Your online payment is confirmed.\nSuccessfully paid %.2f for visiting %s \n", getTicketPrice(), getName());

    }

    @Override
    public void viewAlternativeRoute() {
        System.out.printf("You will be redirected to alternative route to your %s %s\n",
                getSightSeeingType().toString().toLowerCase(), getAddress());
    }
}
