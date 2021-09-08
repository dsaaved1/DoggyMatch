package com._rk_1.experiment2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com._rk_1.experiment2.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
  @Query("select u from user where u.email = ?1")
  User findByEmail(String email);
}