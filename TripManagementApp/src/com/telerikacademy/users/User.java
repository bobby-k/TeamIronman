package com.telerikacademy.users;


import com.telerikacademy.exceptions.IncorrectInputException;

public class User {
    //constants
    private static final int MIN_ACCOUNT_LENGTH = 7;
    private static final int MAX_ACCOUNT_LENGTH = 20;
    private static final int MIN_PASSWORD_LENGTH = 6;
    private static final int MAX_PASSWORD_LENGTH = 15;
    //variables
    private String account;
    private String password;
    private String fullName;
    private String email;
    //private list trips or something like that

    //constructors
    public User(String account, String password, String fullName, String email) throws IncorrectInputException {
        setAccount(account);
        setPassword(password);
        setFullName(fullName);
        setEmail(email);
    }

    //setters and getters
    public String getAccount() {
        return account;
    }

    private void setAccount(String account) throws IncorrectInputException {
        //check whether account is correct
        if (account.equals("") || account.length() < MIN_ACCOUNT_LENGTH) {
            throw new IncorrectInputException("Account should be at least 7 characters long!");
        }
        if (account.length() > MAX_ACCOUNT_LENGTH) {
            throw new IncorrectInputException("Account should be maximum 20 characters long!");
        }
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) throws IncorrectInputException {
        //check whether password is correct
        if (password.equals("") || password.length() < MIN_PASSWORD_LENGTH) {
            throw new IncorrectInputException("Password should be at least 6 characters long!");
        }
        if (password.length() > MAX_PASSWORD_LENGTH) {
            throw new IncorrectInputException("Password should be maximum 15 characters long!");
        }
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    private void setFullName(String fullName) throws IncorrectInputException {
        //check whether full name is correct
        if (fullName.equals("") || !(fullName.contains(" "))) {
        throw new IncorrectInputException("Incorrect full name!");
        }
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) throws IncorrectInputException {
        //check whether email is correct
        if (!(email.contains("@")) && !(email.contains("."))) {
            throw new IncorrectInputException("Incorrect e-mail!");
        }
        this.email = email;
    }
}