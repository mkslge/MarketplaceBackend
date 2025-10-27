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
    @Setter
    private String hashedPassword;

    @Getter
    @Setter
    private SessionID sessionID;


    public Account() {

    }

    public Account(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.hashedPassword = LoginUtility.hash(password);
        this.sessionID = new SessionID();
    }

    public Account(String email, String username, String password, String sessionID) {
        this.email = email;
        this.username = username;
        this.hashedPassword = LoginUtility.hash(password);
        this.sessionID = new SessionID(sessionID);
    }

    public boolean setPassword(String password) {
        this.hashedPassword = LoginUtility.hash(password);
        return true;
    }



    public boolean passwordCorrect(String hashedPassword) {
        return this.hashedPassword.equals(hashedPassword);
    }

    public void setHashedSessionID(String hashedSessionID) {
        this.sessionID = new SessionID();
        this.sessionID.setHashedSessionID(hashedSessionID);
        this.sessionID.updateExpiryDate();
    }






}
