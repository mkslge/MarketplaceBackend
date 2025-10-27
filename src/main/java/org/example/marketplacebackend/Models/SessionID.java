package org.example.marketplacebackend.Models;

import jakarta.websocket.Session;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.example.marketplacebackend.Utility.LoginUtility;
import org.springframework.data.annotation.Id;

import java.util.Calendar;
import java.util.Date;

public class SessionID {

    @Id
    @Setter
    @Getter
    private String hashedSessionID;
    @Getter
    @Setter
    private Date expiryTime;

    public SessionID() {

    }

    public SessionID(String sessionID, Date expiryTime) {
        this.hashedSessionID = LoginUtility.hash(sessionID);
        this.expiryTime = expiryTime;
    }

    public SessionID(String sessionID) {
        this.hashedSessionID = LoginUtility.hash(sessionID);
        this.expiryTime = this.generateDefaultExpiryTime();
    }

    private Date generateDefaultExpiryTime() {
        Date currentTime = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.add(Calendar.HOUR_OF_DAY, 24);

        return calendar.getTime();
    }



    public boolean sessionIDExpired() {
        return expiryTime.after(new Date());
    }

    public void updateExpiryDate() {
        this.expiryTime = this.generateDefaultExpiryTime();
    }
}
