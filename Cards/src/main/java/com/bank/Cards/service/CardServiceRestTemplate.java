package com.bank.Cards.service;

import com.bank.Cards.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CardServiceRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    public Account getAccountDetails(Long id) {
        Account account = null;
        try {
            if(id != null)
            account = restTemplate.getForObject("http://localhost:8087/accounts-app/{accountId}",Account.class,id);
          else
              throw new RuntimeException("Id not found");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return account;
    }
}
