package com._rk_1.experiment2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Collection;

import com._rk_1.experiment2.Entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
  @Query("SELECT u FROM user u WHERE u.email = ?1")
  public List<User> findByEmail(String email);
}