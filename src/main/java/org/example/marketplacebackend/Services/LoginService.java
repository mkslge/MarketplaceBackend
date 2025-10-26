package org.example.marketplacebackend.Services;

import org.example.marketplacebackend.Config.MongoDBSingleton;
import org.example.marketplacebackend.Models.Account;
import org.example.marketplacebackend.Repositories.AccountRepository;
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

    public void setSessionID() {

    }


}
