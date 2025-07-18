package com.bank.accountApp.service;

import com.bank.accountApp.model.Account;
import com.bank.accountApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;


    public Account getAccountByAccountId(Long accountId) {
        return accountRepository.findById(accountId).get();
    }
}
