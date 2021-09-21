package com.iastate._rk_1.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "preferences")
public class Preferences {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "energy")
  private int energy;

  @Column(name = "active")
  private int active;

  @Column(name = "dog_park")
  private boolean dogPark;

  @Column(name = "water")
  private boolean water;

  @Column(name = "at_home")
  private boolean atHome;

  public Preferences() {
  }

  public Preferences(int energy, int active, boolean dogPark, boolean water, boolean atHome) {
    this.energy = energy;
    this.active = active;
    this.dogPark = dogPark;
    this.water = water;
    this.atHome = atHome;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getEnergy() {
    return energy;
  }

  public void setEnergy(int energy) {
    this.energy = energy;
  }

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  public boolean isDogPark() {
    return dogPark;
  }

  public void setDogPark(boolean dogPark) {
    this.dogPark = dogPark;
  }

  public boolean isWater() {
    return water;
  }

  public void setWater(boolean water) {
    this.water = water;
  }

  public boolean isAtHome() {
    return atHome;
  }

  public void setAtHome(boolean atHome) {
    this.atHome = atHome;
  }
}