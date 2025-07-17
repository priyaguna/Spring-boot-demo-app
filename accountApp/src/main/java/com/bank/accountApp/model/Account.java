package com.bank.accountApp.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long accountId;

    @NotBlank
    private String branch;

    @NotBlank
    private String accountType;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @Valid
    @JoinColumn(name="customer_id")
    private User user;

}
