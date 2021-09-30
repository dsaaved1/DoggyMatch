package com.iastate._rk_1.backend.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private Date date;

  @Column
  private String content;

  @ManyToOne
  private User to;

  @ManyToOne
  @Column
  private User from;

  public Message() {

  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public User getTo() {
    return this.to;
  }

  public void setTo(User to) {
    this.to = to;
  }

  public User getFrom() {
    return this.from;
  }

  public void setFrom(User from) {
    this.from = from;
  }

}
