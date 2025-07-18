package com.bank.Cards.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String firstName;
    private String lastName;
    private String email;
}
