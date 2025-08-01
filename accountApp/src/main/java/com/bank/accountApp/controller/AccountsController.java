package com.bank.accountApp.controller;

import com.bank.accountApp.config.ConfigProperties;
import com.bank.accountApp.model.ResponseModel;
import com.bank.accountApp.repository.AccountRepository;
import com.bank.accountApp.model.Account;
import com.bank.accountApp.repository.UserRepository;
import com.bank.accountApp.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts-app")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountRepository accountRepo;
    private final UserRepository userRepo;


    @Autowired
    AccountService accountService;

    @Autowired
    ConfigProperties configProperties;

    @PostMapping
    public ResponseEntity<Account> createAccount(
            @RequestBody @Valid Account account,
            @RequestHeader("userInfo") String userInfoHeader) {
        return ResponseEntity.ok(accountRepo.save(account));
    }

    @GetMapping("/{accountId}")
    public Account getAccountsWithAccountId(@PathVariable Long accountId){
        return accountService.getAccountByAccountId(accountId);
    }


    @GetMapping("/config-property")
    public ResponseEntity<ResponseModel> configProperties(){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setBankName(configProperties.getBankName());
        responseModel.setCardName(configProperties.getCardName());
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }
}
