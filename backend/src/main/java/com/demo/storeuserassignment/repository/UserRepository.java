package com.demo.storeuserassignment.repository;

import com.demo.storeuserassignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
