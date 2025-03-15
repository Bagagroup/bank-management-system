package com.bank.model;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountType; // Savings or Checking
    private double balance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public String getAccountType() { return accountType; }
    public void setAccountType(String accountType) { this.accountType = accountType; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}
