package org.example.marketplacebackend.Models;

import org.example.marketplacebackend.Utility.LoginUtility;

public class Account {
    private String email;
    private String username;
    private String hashedPassword;

    public Account(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.hashedPassword = LoginUtility.hashPassword(password);
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean setPassword(String password) {
        this.hashedPassword = LoginUtility.hashPassword(password);
        return true;
    }

    public boolean samePassword(String password) {
        return this.hashedPassword.equals(LoginUtility.hashPassword(password));
    }




}
