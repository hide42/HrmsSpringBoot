package com.jpa.practice.jpaPractice.authentication.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.practice.jpaPractice.authentication.model.security.User;

/**
 * Created by stephan on 20.03.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}