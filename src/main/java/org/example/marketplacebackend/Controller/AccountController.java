package org.example.marketplacebackend.Controller;

import org.example.marketplacebackend.Models.Account;
import org.example.marketplacebackend.Models.SessionID;
import org.example.marketplacebackend.Repositories.AccountRepository;
import org.example.marketplacebackend.Services.LoginService;
import org.example.marketplacebackend.Services.SignupService;
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

    @Autowired
    private SignupService signupService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/signup")
    public ResponseEntity<Account> registerAccount(@RequestBody Account account) {
        return signupService.createAccount(account) ?
                ResponseEntity.status(HttpStatus.CREATED).body(account) :
                ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @PostMapping("/login/unsaved")
    public ResponseEntity<Account> loginUncached(@RequestBody Account account) {
        return null;
    }

    @PostMapping("/login/saved")
    public ResponseEntity<Account> loginUncached(@RequestBody SessionID sessionID) {
        return null;
    }







    
}