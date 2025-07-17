package com.bank.accountApp.configuration;


import com.bank.accountApp.model.Account;
import com.bank.accountApp.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("dev")
public class AccountConfigDev {


    @Bean("accounts")
    public List<Account> getAccounts(){
        return List.of(
                new Account(1L, "dev-12345","BLR", new User(1L,"Ram","Ram","Krishna","ram@gmail.com")),
                new Account(2L,"dev-67890","CTA", new User(2L,"Raj","Raj","Kumar","raj@gmail.com")));
    }
}
