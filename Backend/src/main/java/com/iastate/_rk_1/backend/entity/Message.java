package com.iastate._rk_1.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String date;
  private String content;
  @ManyToOne
  @JoinColumn(name = "to")
  private User to;
  @ManyToOne
  @JoinColumn(name = "from")
  private User from;

  public Message() {
    super();
  }

  public Message(String date, String content, User to, User from) {
    super();
    this.date = date;
    this.content = content;
    this.to = to;
    this.from = from;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public User getTo() {
    return to;
  }

  public void setTo(User to) {
    this.to = to;
  }

  public User getFrom() {
    return from;
  }

  public void setFrom(User from) {
    this.from = from;
  }

}
