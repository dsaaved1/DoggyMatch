package com.iastate._rk_1.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conduct_violation")
public class ConductViolation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "date")
  private String date;

  @Column(name = "user")
  private String user;

  @Column(name = "notes")
  private String notes;

  public ConductViolation() {
  }

  public ConductViolation(String date, String user, String notes) {
    this.date = date;
    this.user = user;
    this.notes = notes;
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
  public String getDate() {
    return date;
  }

  /**
   *
   * @param date
   */
  public void setDate(String date) {
    this.date = date;
  }

  /**
   *
   * @return
   */
  public String getUser() {
    return user;
  }

  /**
   *
   * @param user
   */
  public void setUser(String user) {
    this.user = user;
  }

  /**
   *
   * @return
   */
  public String getNotes() {
    return notes;
  }

  /**
   *
   * @param notes
   */
  public void setNotes(String notes) {
    this.notes = notes;
  }
}