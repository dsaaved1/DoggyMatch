package com.iastate._rk_1.backend.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moderator")
public class Moderator {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "hashedPassword")
  private String hashedPassword;

  @Column(name = "codeModerator")
  private String codeModerator;

  @Column(name = "lastLoginTime")
  private Date lastLoginTime;

  @Column(name = "privacySettings")
  private String privacySettings;

  public Moderator() {

  }

  public Moderator(String email, String hashedPassword, String codeModerator, Date lastLoginTime,
      String privacySettings) {
    this.email = email;
    this.hashedPassword = hashedPassword;
    this.codeModerator = codeModerator;
    this.lastLoginTime = lastLoginTime;
    this.privacySettings = privacySettings;
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

  public String getCodeModerator() {
    return codeModerator;
  }

  public void setCodeModerator(String codeModerator) {
    this.codeModerator = codeModerator;
  }

  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  public String getPrivacySettings() {
    return privacySettings;
  }

  public void setPrivacySettings(String privacySettings) {
    this.privacySettings = privacySettings;
  }
}