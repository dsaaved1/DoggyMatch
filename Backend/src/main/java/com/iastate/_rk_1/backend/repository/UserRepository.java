package com.iastate._rk_1.backend.repository;

import com.iastate._rk_1.backend.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  /**
   * Gets a user by the provided email
   * @param email the email of the user to get
   * @return he User object if the email provided matches with an existing User
   */
  User findByEmail(String email);

  /**
   * Gets a user by the provided name
   * @param firstName the name of the user to get
   * @return the User object if the name provided matches with an existing User
   */
  User findByFirstName(String firstName);

  /**
   * Gets a user by the provided id
   * @param id the id of the user to get
   * @return the User object if the id provided matches with an existing User
   */
  User findById(int id);
}
