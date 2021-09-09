package com._rk_1.experiment2.Repository;

import com._rk_1.experiment2.Entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
  @Query("SELECT u FROM user u WHERE u.email = ?1")
  public User findByEmail(String email);
}