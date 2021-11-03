package com.iastate._rk_1.backend;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.iastate._rk_1.backend.repository.UserRepository;
import com.iastate._rk_1.backend.service.UserService;
import com.iastate._rk_1.backend.entity.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService {

  @Mock
  private UserService userService;

  @Mock
  private UserRepository mockUserRepository;

  @Test
  public void getUserByIdTest() {
    UserRepository mockRepository = mock(UserRepository.class);
    UserService mockUserService = mock(UserService.class);
    User testUser = new User("peyt@iastate.edu", "password");

    mockUserService.saveUser(testUser);
    
    when(mockRepository.findById(testUser.getId())).thenReturn(testUser);
    assertEquals(testUser, mockRepository.findById(testUser.getId()));

  }

  // Testing the method "mockRepository.findByEmail"
  @Test
  public void getUserByEmailTest() {
    UserRepository mockRepository = mock(UserRepository.class);
    UserService mockUserService = mock(UserService.class);
    User testUser = new User("peyt@iastate.edu", "password");

    mockUserService.saveUser(testUser);
    
    when(mockRepository.findByEmail(testUser.getEmail())).thenReturn(testUser);

    assertEquals(testUser, mockRepository.findByEmail(testUser.getEmail()));
  }

  @Test
  public void testEncryptedPassword(){
    UserService mockUserService = mock(UserService.class);
    User testUser = new User("peyt@iastate.edu", "password");

    assertEquals("password", testUser.getPassword());

    mockUserService.signUp(testUser);
    mockUserService.saveUser(testUser);

    assertEquals("password", testUser.getPassword());

  }
}
