package org.example.marketplacebackend.Controller;

import org.example.marketplacebackend.Models.Account;
import org.example.marketplacebackend.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/accounts")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {
    
    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/register")
    public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
        // Check if an account with the same email already exists
        if (accountRepository.findByEmail(account.getEmail()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409 Conflict
        }

        // Save the new account
        Account savedAccount = accountRepository.save(account);

        // Return 201 Created with the saved account
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
    }

    
}