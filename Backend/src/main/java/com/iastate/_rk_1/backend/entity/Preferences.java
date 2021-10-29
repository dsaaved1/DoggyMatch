package com.iastate._rk_1.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "preferences")
public class Preferences {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "breed")
  private String breed;

  @Column(name = "ageDog")
  private int ageDog;

  @Column(name = "genderDog")
  private String genderDog;

  @Column(name = "energyDog")
  private String energyDog;

  @Column(name = "dog_park")
  private boolean dogPark;

  @Column(name = "at_home")
  private boolean atHome;

  @OneToOne(mappedBy = "preferences")
  private User user;

  public Preferences() {
  }

  public Preferences(String breed, int ageDog, String genderDog, String energyDog, boolean dogPark, boolean atHome) {
    this.breed = breed;
    this.ageDog = ageDog;
    this.genderDog = genderDog;
    this.energyDog = energyDog;
    this.dogPark = dogPark;
    this.atHome = atHome;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBreed() {
    return breed;
  }

  public void setBreed(String breed) {
    this.breed = breed;
  }

  public int getAgeDog() {
    return ageDog;
  }

  public void setAgeDog(int ageDog) {
    this.ageDog = ageDog;
  }

  public String getGenderDog() {
    return genderDog;
  }

  public void setGenderDog(String genderDog) {
    this.genderDog = genderDog;
  }

  public String getEnergyDog() {
    return energyDog;
  }

  public void setEnergy(String energyDog) {
    this.energyDog = energyDog;
  }


  public boolean isDogPark() {
    return dogPark;
  }

  public void setDogPark(boolean dogPark) {
    this.dogPark = dogPark;
  }

  public boolean isAtHome() {
    return atHome;
  }

  public void setAtHome(boolean atHome) {
    this.atHome = atHome;
  }
}