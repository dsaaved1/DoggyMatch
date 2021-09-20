package com.iastate._rk_1.backend.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "viewer")
public class Viewer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "email")
  private String email;

  @Column(name = "hashedPassword")
  private String hashedPassword;

  @Column(name = "active")
  private boolean active;

  @Column(name = "lastLoginTime")
  private Date lastLoginTime;

  public Viewer() {
  }

  public Viewer(String email, String hashedPassword, boolean active, Date lastLoginTime) {
    this.email = email;
    this.hashedPassword = hashedPassword;
    this.active = active;
    this.lastLoginTime = lastLoginTime;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getHashedPassword() {
    return hashedPassword;
  }

  public void setHashedPassword(String hashedPassword) {
    this.hashedPassword = hashedPassword;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }
}