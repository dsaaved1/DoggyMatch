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

  public Chat() {
  }

  
  /** 
   * @return int id
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
   *
   * @return userMail
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
