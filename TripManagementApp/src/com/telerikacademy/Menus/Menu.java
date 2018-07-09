package com.telerikacademy.menus;


import com.telerikacademy.models.Application;

import java.text.ParseException;

public abstract class Menu {
    private Application app;

    public Menu(Application app) {
        this.app = app;
    }

    public Application getApp() {
        return app;
    }

    public abstract void printMenu();

    public abstract void selectOptions() throws ParseException;
}