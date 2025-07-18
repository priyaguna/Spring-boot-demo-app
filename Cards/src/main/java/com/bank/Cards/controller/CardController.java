package com.bank.Cards.controller;

import com.bank.Cards.model.Account;
import com.bank.Cards.service.CardServiceRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    CardServiceRestTemplate cardServiceRestTemplate;

    @GetMapping("/{accountId}")
    public Account getResponseRestTemplate(@PathVariable Long accountId) {
        return cardServiceRestTemplate.getAccountDetails(accountId);
    }
}
