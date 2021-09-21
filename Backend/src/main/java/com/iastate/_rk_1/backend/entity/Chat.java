package com.iastate._rk_1.backend.entity;

import java.util.Set;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@Table(name = "chat")
public class Chat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "date")
  private Date date;

  @ManyToMany(fetch = FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE)
  @JoinTable(name = "chat_user", joinColumns = @JoinColumn(name = "chat_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
  private Set<User> users;

  @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
  @LazyCollection(LazyCollectionOption.FALSE)
  private Set<Message> messages;

  public Chat() {
  }

  public Chat(Date date, Set<User> users, Set<Message> messages) {
    this.date = date;
    this.users = users;
    this.messages = messages;
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

  public Set<User> getUsers() {
    return users;
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }

  public Set<Message> getMessages() {
    return messages;
  }

  public void setMessages(Set<Message> messages) {
    this.messages = messages;
  }

}