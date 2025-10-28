package org.example.marketplacebackend.Services;

import lombok.extern.java.Log;
import org.example.marketplacebackend.Config.MongoDBSingleton;
import org.example.marketplacebackend.Models.Account;
import org.example.marketplacebackend.Repositories.AccountRepository;
import org.example.marketplacebackend.Utility.LoginUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    AccountRepository accountRepository;

    @Autowired
    public LoginService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }



    public void setSessionID(Account account) {
        String hashedSessionID;
        do {
            hashedSessionID = LoginUtility.hash(LoginUtility.generateSessionID());

        } while(accountRepository.existsBySessionID(hashedSessionID));

        account.setHashedSessionID(hashedSessionID);
    }

    public boolean verifySessionID(String sessionID) {
        String hashedSessionID = LoginUtility.hash(sessionID);
        return accountRepository.existsBySessionID(hashedSessionID);
    }


}
