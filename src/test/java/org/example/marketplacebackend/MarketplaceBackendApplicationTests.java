package org.example.marketplacebackend;

import org.example.marketplacebackend.Models.Account;
import org.example.marketplacebackend.Repositories.AccountRepository;
import org.example.marketplacebackend.Services.SignupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import static reactor.core.publisher.Mono.when;

@SpringBootTest
class MarketplaceBackendApplicationTests {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    SignupService signupService;


    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void testMongoConnection() {
        System.out.println("MongoTemplate database name: " + mongoTemplate.getDb().getName());
    }



    @Test
    void contextLoads() {
        System.out.println("All accounts in DB:");
        accountRepository.findAll().forEach(a ->
                System.out.println(a.getEmail() + " / " + a.getUsername())
        );
    }

    @Test
    void testAddingAccount() {
        Account account = new Account("test123123@gmail.com", "test123123", "test123");
        boolean result = signupService.createAccount(account);
        if(result) {
            System.out.println("made account");
        } else {
            System.out.println("Account crud failed");
        }

        Account saved = accountRepository.save(account);
        System.out.println("Saved account id: " + saved.getEmail());

        System.out.println("All accounts in DB:");
        accountRepository.findAll().forEach(a ->
                System.out.println(a.getEmail() + " / " + a.getUsername())
        );



    }






}
