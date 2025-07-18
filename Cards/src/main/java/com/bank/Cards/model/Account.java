package com.bank.Cards.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Long accountId;
    private String branch;
    private String accountType;
    private User user;

}
