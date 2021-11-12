package com.iastate._rk_1.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
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

  @Column(name = "date")
  private Date date;


  @JsonIgnore
  @ManyToMany(mappedBy = "chats")
  private Set<User> usersInChat = new HashSet<>();

  public Chat() {
  }

  
  /** 
   * @return int
   */
  public int getId() {
    return id;
  }

  
  /** 
   * @param id
   */
  public void setId(int id) {
    this.id = id;
  }


  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }


  public String getUserMail() {
    return userMail;
  }

  
  /** 
   * @param userMail
   */
  public void setUserMail(String userMail) {
    this.userMail = userMail;
  }


  public Set<User> getUsersInChat() {
    return usersInChat;
  }

  public void setUsersInChat(Set<User> usersInChat) {
    this.usersInChat = usersInChat;
  }
}
