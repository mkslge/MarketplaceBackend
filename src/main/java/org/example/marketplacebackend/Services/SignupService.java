package org.example.marketplacebackend.Services;

import org.example.marketplacebackend.Config.MongoDBSingleton;
import org.example.marketplacebackend.Models.Account;
import org.example.marketplacebackend.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;


@Service
public class SignupService {

    int MIN_PASSWORD_LENGTH = 0;
    int MAX_PASSWORD_LENGTH  = 255;

    AccountRepository accountRepository;




    @Autowired
    public SignupService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    /*
    Function creates a new object and adds it the database, it ensures that
    there is no account with the same email or username
     */
    public boolean createAccount(Account account) {
        if(accountRepository.existsByEmail(account.getEmail())) {
            return false;
        } else if(accountRepository.existsByUsername(account.getUsername())) {
            return false;
        }

        //ensuring there is no error in the adding of the account
        try {
            accountRepository.save(account);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean changePassword(Account account, String oldPassword, String newPassword) {

        if(!account.passwordCorrect(oldPassword) || !isStrongPassword(newPassword)) {
            return false;
        } else {
            //change password
            account.setHashedPassword(newPassword);
            return true;
        }

    }

    private boolean isStrongPassword(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH && password.length() <= MAX_PASSWORD_LENGTH;
    }
}
