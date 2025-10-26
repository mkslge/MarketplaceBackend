package org.example.marketplacebackend.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.marketplacebackend.Utility.LoginUtility;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Accounts")
public class Account {
    @Getter
    @Setter
    @Id
    private String email;

    @Getter
    @Setter
    private String username;

    @Getter
    private String hashedPassword;

    @Getter
    @Setter
    private String sessionID;

    public Account() {

    }

    public Account(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.hashedPassword = LoginUtility.hashPassword(password);
        this.sessionID = "";
    }

    public Account(String email, String username, String password, String sessionID) {
        this.email = email;
        this.username = username;
        this.hashedPassword = LoginUtility.hashPassword(password);
        this.sessionID = sessionID;
    }

    public boolean setPassword(String password) {
        this.hashedPassword = LoginUtility.hashPassword(password);
        return true;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public boolean passwordCorrect(String hashedPassword) {
        return this.hashedPassword.equals(hashedPassword);
    }






}
