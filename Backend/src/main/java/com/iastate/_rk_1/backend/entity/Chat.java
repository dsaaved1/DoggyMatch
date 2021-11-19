package com.iastate._rk_1.backend.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "chat")
public class Chat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  private String userMail;

  //@Column(name = "date")
  //private Date date;

  //@OneToOne
  //private User user;

  //@OneToMany
  //private Set<User> users = new HashSet<>();

  public Chat() {
  }

  
  /** 
   * @return int
   */
  public int getId() {
    return id;
  }

  
  /** 
   * @param id the id to be set
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
   */

  public String getUserMail() {
    return userMail;
  }

  
  /** 
   * @param userMail the mail of the user
   */
  public void setUserMail(String userMail) {
    this.userMail = userMail;
  }

}
