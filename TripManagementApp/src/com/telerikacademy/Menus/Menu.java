package com.telerikacademy.Menus;


import com.telerikacademy.models.Application;

public abstract class Menu {
    private Application app;

    public Menu(Application app){
        this.app = app;
    }


    public abstract void printMenu();

    public abstract void selectOptions();


}
