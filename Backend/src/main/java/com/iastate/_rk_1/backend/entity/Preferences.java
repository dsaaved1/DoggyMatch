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
   * @return breed of the dog
   */
  public String getBreed() {
    return breed;
  }

  /**
   * Updates the breed of the dog
   * @param breed
   */
  public void setBreed(String breed) {
    this.breed = breed;
  }

  /**
   *
   * @return age of User's dog
   */
  public int getAgeDog() {
    return ageDog;
  }

  /**
   * Updates the age of the dog
   * @param ageDog
   */
  public void setAgeDog(int ageDog) {
    this.ageDog = ageDog;
  }

  /**
   *
   * @return
   */
  public String getGenderDog() {
    return genderDog;
  }

  /**
   *
   * @param genderDog
   */
  public void setGenderDog(String genderDog) {
    this.genderDog = genderDog;
  }

  /**
   *
   * @return
   */
  public String getEnergyDog() {
    return energyDog;
  }

  /**
   *
   * @param energyDog
   */
  public void setEnergy(String energyDog) {
    this.energyDog = energyDog;
  }

  /**
   *
   * @return
   */
  public boolean isDogPark() {
    return dogPark;
  }

  /**
   *
   * @param dogPark
   */
  public void setDogPark(boolean dogPark) {
    this.dogPark = dogPark;
  }

  /**
   *
   * @return
   */
  public boolean isAtHome() {
    return atHome;
  }

  /**
   *
   * @param atHome
   */
  public void setAtHome(boolean atHome) {
    this.atHome = atHome;
  }
}