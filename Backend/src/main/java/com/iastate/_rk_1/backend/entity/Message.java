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

  /**
   *
   * @return
   */
  public int getId() {
    return this.id;
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
  public Date getDate() {
    return this.date;
  }

  /**
   *
   * @param date
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   *
   * @return
   */
  public String getContent() {
    return this.content;
  }

  /**
   *
   * @param content
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   *
   * @return
   */
  public User getTo() {
    return this.to;
  }

  /**
   *
   * @param to
   */
  public void setTo(User to) {
    this.to = to;
  }

  /**
   *
   * @return
   */
  public User getFrom() {
    return this.from;
  }

  /**
   *
   * @param from
   */
  public void setFrom(User from) {
    this.from = from;
  }

}
