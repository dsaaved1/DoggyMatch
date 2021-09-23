package com.iastate._rk_1.backend.repository;

import com.iastate._rk_1.backend.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByEmail(String email);

  User findByFirstName(String firstName);
}
