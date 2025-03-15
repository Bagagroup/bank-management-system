package com.bank.repository;

import com.bank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // ✅ Return Optional<User> instead of User
    Optional<User> findByUsername(String username);
}