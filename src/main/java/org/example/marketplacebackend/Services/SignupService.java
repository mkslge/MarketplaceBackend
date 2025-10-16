package org.example.marketplacebackend.Services;

import org.example.marketplacebackend.Config.MongoDBSingleton;
import org.example.marketplacebackend.Models.Account;
import org.springframework.web.bind.annotation.RestController;


public class SignupService {
    MongoDBSingleton conn = MongoDBSingleton.getMongoDBConnection();


    public static boolean createAccount(Account account) {
        //validate that we dont have duplicate email or username
        //if so create account
        //otherwise create new account and add it to DB


        return true;
    }

    public static boolean changePassword(Account account, String oldPassword, String newPassword) {

        if(!account.samePassword(oldPassword) || !isStrongPassword(newPassword)) {
            return false;
        } else {
            //change password
            account.setPassword(newPassword);

        }

        return true;
    }

    private static boolean isStrongPassword(String password) {
        return password.length() >= 8;
    }
}
