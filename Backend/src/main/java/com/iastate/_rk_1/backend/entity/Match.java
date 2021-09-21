package com.iastate._rk_1.backend.entity;

import java.util.List;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;

@Entity
@Table(name = "match")
public class Match {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "date")
  private Date date;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "match_user", joinColumns = @JoinColumn(name = "match_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private List<User> users;

  public Match() {
    super();
  }

  public Match(Date date, List<User> users) {
    super();
    this.date = date;
    this.users = users;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

}