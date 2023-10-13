package com.labs.managerstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.labs.managerstore.models.User;

public interface UserRepository extends JpaRepository<User, Long> {}
