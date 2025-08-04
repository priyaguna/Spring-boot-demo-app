package com.bank.accountApp.repository;

import com.bank.accountApp.model.Account;
import com.bank.accountApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String emailId);
}
