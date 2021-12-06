package com.iastate._rk_1.backend.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "moderator")
public class Moderator{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ApiModelProperty(notes = "email of user",name="email",required=true,value="test email")
  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "codeModerator")
  private String codeModerator;

  @Column(name = "password")
  private String password;

  @Column(name = "active")
  private boolean active;

  @Column(name = "lastLoginTime")
  private Date lastLoginTime;

  @OneToMany(cascade = {CascadeType.ALL})
  private Set<User> deletedUsers = new HashSet<>();


  public Moderator(String email, String password, String codeModerator) {
    this.email = email;
    this.password = password;
    this.codeModerator = codeModerator;
    this.active = true;
    this.lastLoginTime = new Date();
  }

  public Moderator() {

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

  /**
   * @return String
   */
  public String getEmail() {
    return email;
  }


  /**
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * @return String
   */
  public String getPassword(){
    return password;
  }


  /**
   * Changes the password with the generated encrypted password
   * @param encryptedPassword
   */
  public void setEncryptedPassword(String encryptedPassword){
    this.password = encryptedPassword;
  }

  /**
   *
   * @return
   */
  public String getCodeModerator() {
    return codeModerator;
  }

  /**
   *
   * @param codeModerator
   */
  public void setCodeModerator(String codeModerator) {
    this.codeModerator = codeModerator;
  }


  /**
   * @return boolean
   */
  public boolean getActive() {
    return active;
  }


  /**
   * @param active
   */
  public void setActive(boolean active) {
    this.active = active;
  }


  /**
   * @return Date
   */
  public java.util.Date getLastLoginTime() {
    return lastLoginTime;
  }


  /**
   * @param lastLoginTime
   */
  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }


  public Set<User> getDeletedUsers() {
    return deletedUsers;
  }

  public void setDeletedUsers(Set<User> deletedUsers) {
    this.deletedUsers = deletedUsers;
  }

}