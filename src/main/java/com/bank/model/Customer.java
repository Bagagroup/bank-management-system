package com.bank.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    // Getters & Setters
}
