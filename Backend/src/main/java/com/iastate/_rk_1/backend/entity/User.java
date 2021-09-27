package com.iastate._rk_1.backend.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "email", unique = true, nullable = false)
  private String email;

  @Column(name = "active")
  private boolean active;

  @Column(name = "lastLoginTime")
  private Date lastLoginTime;

  @Column(name = "privacySettings")
  private String privacySettings;

  @Column(name = "firstName", nullable = false)
  private String firstName;

  @Column(name = "lastName", nullable = false)
  private String lastName;

  @Column(name = "age")
  private int age;

  @Column(name = "address")
  private String address;

  @Column(name = "university")
  private String university;

  @Column(name = "gender")
  private String gender;

  @Column(name = "photo")
  private String photo;

  @Column(name = "reference_dog_info_table")
  private String referenceDogInfoTable;

  public User() {
  }

  public User(String firstName, String lastName, String email, String password) {
    this.email = email;
    this.active = true;
    this.lastLoginTime = new Date();
    this.privacySettings = null;
    this.firstName = firstName;
    this.lastName = lastName;

    this.age = 0;
    this.address = null;
    this.university = null;
    this.gender = null;
    this.photo = null;
    this.referenceDogInfoTable = null;
  }

  public boolean getActive() {
    return this.active;
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

  public String getPrivacySettings() {
    return privacySettings;
  }

  public void setPrivacySettings(String privacySettings) {
    this.privacySettings = privacySettings;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getUniversity() {
    return university;
  }

  public void setUniversity(String university) {
    this.university = university;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public String getReferenceDogInfoTable() {
    return referenceDogInfoTable;
  }

  public void setReferenceDogInfoTable(String referenceDogInfoTable) {
    this.referenceDogInfoTable = referenceDogInfoTable;
  }
}
