package com.iastate._rk_1.backend.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "viewer")
public class Viewer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @ApiModelProperty(notes = "email of user",name="email",required=true,value="test email")
  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "password")
  private String password;

  @Column(name = "active")
  private boolean active;

  @Column(name = "lastLoginTime")
  private Date lastLoginTime;

  public Viewer(String email, String password) {
    this.email = email;
    this.password = password;
    this.active = true;
    this.lastLoginTime = new Date();
  }

  public Viewer() {

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

}