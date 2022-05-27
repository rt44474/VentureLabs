package com.example.task1.user.repository;

import com.example.task1.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryI extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
