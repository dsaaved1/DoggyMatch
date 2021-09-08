package com._rk_1.experiment2.Repository;

import org.springframework.data.repository.CrudRepository;
import com._rk_1.experiment2.Entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}