package com.bank.accountApp.controller;

import com.bank.accountApp.exception.CustomerAlreadyExistsException;
import com.bank.accountApp.model.User;
import com.bank.accountApp.repository.AccountRepository;
import com.bank.accountApp.configuration.AccountConfigDev;
import com.bank.accountApp.model.Account;
import com.bank.accountApp.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts-app")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountRepository accountRepo;
    private final UserRepository userRepo;


    @Value("${name}")
    String name;

    @Autowired
    AccountConfigDev accountConfigDev;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<Account> getAccounts(){

        return accountConfigDev.getAccounts();
    }

    @GetMapping("/get-property-name")
    public String getPropertiesValue() {
        return name;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(
            @RequestBody @Valid Account account,
            @RequestHeader("userInfo") String userInfoHeader) {
        Optional<User> existingUser = userRepository.findByEmail(account.getUser().getEmail());
        if(existingUser.isPresent()){
            throw new CustomerAlreadyExistsException("Customer already exists with given emailId: "+ existingUser.get().getEmail());
        }
        return ResponseEntity.ok(accountRepo.save(account));
    }

}
