package com.telerikacademy;

import com.telerikacademy.exceptions.IncorrectInputException;
import com.telerikacademy.menus.LoginMenu;
import com.telerikacademy.menus.Menu;
import com.telerikacademy.models.Application;
import com.telerikacademy.users.User;

public class Main {

  public static void main(String[] args) {
    try {
      User testUser = new User("testing", "testing", "Test Test", "test@abv.bg");
      Application application = new Application("test");
      Menu menu = new LoginMenu(application);
      menu.selectOptions();
    } catch (IncorrectInputException e) {
      System.out.println(e.getMessage());
    }


  }

}
