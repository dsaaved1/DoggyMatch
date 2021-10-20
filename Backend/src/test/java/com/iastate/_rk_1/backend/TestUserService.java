package com.iastate._rk_1.backend;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.iastate._rk_1.backend.repository.UserRepository;
import com.iastate._rk_1.backend.service.UserService;
import com.iastate._rk_1.backend.entity.User;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TestUserService {
  @Test
  public void getUserByIdTest() {
    UserRepository mockRepository = mock(UserRepository.class);
    UserService mockUserService = mock(UserService.class);
    User testUser = new User(1, "Peyton", "Arbuckle", "peyt@iastate.edu", "password");

    mockUserService.saveUser(testUser);

    assertEquals("peyt@iastate.edu", testUser.getEmail());
  }

  @Test
  public void testEncryptedPassword(){
    UserService mockUserService = mock(UserService.class);
    User testUser = new User(1, "Peyton", "Arbuckle", "peyt@iastate.edu", "password");

    assertEquals("password", testUser.getPassword());

    mockUserService.signUp(testUser);
    mockUserService.saveUser(testUser);

    assertEquals("password", testUser.getPassword());

  }
}
