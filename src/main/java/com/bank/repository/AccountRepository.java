package com.bank.repository;

import com.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // ✅ Custom query to find accounts by customer ID
    List<Account> findByCustomerId(Long customerId);
}