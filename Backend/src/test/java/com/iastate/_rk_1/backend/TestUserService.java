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

  @Autowired
  private UserService userService;

  @Mock
  private UserRepository mockUserRepository;

  final User testUser = new User(1, "First", "Last", "test@iastate.edu", "password");

  @Test
  public void getUserByIdTest() {

    UserRepository mockRepository = mock(UserRepository.class);
    UserService mockUserService = mock(UserService.class);
    User testUser = new User("Peyton", "Arbuckle", "peyt@iastate.edu", "password");

    mockUserService.saveUser(testUser);

    when(mockUserRepository.getById(1))
            .thenReturn(testUser);
    User user = userService.getUserById(1);
    assertEquals("test@iastate.edu", user.getEmail());
  }

  @Test
  public void findUserByEmailTest() {
    when(mockUserRepository.findByEmail("test@iastate.edu"))
            .thenReturn(testUser);
    assertEquals(1, userService.getUsersByEmail("test@iastate.edu").getId());
  }

  @Test
  public void testEncryptedPassword(){
    UserService mockUserService = mock(UserService.class);
    User testUser = new User("Peyton", "Arbuckle", "peyt@iastate.edu", "password");

    assertEquals("password", testUser.getPassword());

    mockUserService.signUp(testUser);
    mockUserService.saveUser(testUser);

    assertEquals("password", testUser.getPassword());

  }
}
