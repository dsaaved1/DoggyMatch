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

  /**
   *
   * @return
   */
  public int getId() {
    return id;
  }

  /**
   *
   * @param id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   *
   * @return
   */
  public String getEmail() {
    return email;
  }

  /**
   *
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   *
   * @return
   */
  public String getHashedPassword() {
    return hashedPassword;
  }

  /**
   *
   * @param hashedPassword
   */
  public void setHashedPassword(String hashedPassword) {
    this.hashedPassword = hashedPassword;
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
   *
   * @return
   */
  public Date getLastLoginTime() {
    return lastLoginTime;
  }

  /**
   *
   * @param lastLoginTime
   */
  public void setLastLoginTime(Date lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }

  /**
   *
   * @return
   */
  public String getPrivacySettings() {
    return privacySettings;
  }

  /**
   *
   * @param privacySettings
   */
  public void setPrivacySettings(String privacySettings) {
    this.privacySettings = privacySettings;
  }
}