package com.iastate._rk_1.backend.repository;

import com.iastate._rk_1.backend.entity.Viewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewerRepository extends JpaRepository<Viewer, Integer> {

    /**
     * Gets a user by the provided email
     * @param email the email of the user to get
     * @return he User object if the email provided matches with an existing User
     */
    Viewer findByEmail(String email);
}
