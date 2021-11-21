package com.iastate._rk_1.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "dog_info")
public class DogInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "firstNameDog")
  private String firstNameDog;

  @Column(name = "breed")
  private String breed;

  @Column(name = "ageDog")
  private int ageDog;

  @Column(name = "genderDog")
  private String genderDog;

  @Column(name = "energyDog")
  private String energyDog;

  @Column(name = "descriptionDog")
  private String descriptionDog;

  @Column(name = "photosDog")
  private String photosDog;

  @OneToOne(mappedBy = "dogInfo")
  private User user;

  public DogInfo() {
    super();
  }

  public DogInfo(String firstNameDog, String breed, int ageDog, String descriptionDog, String energyDog,
      String genderDog, String photosDog) {
    super();
    this.firstNameDog = firstNameDog;
    this.breed = breed;
    this.ageDog = ageDog;
    this.genderDog = genderDog;
    this.energyDog = energyDog;
    this.descriptionDog = descriptionDog;
    this.photosDog = photosDog;
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
  public String getFirstNameDog() {
    return firstNameDog;
  }

  /**
   *
   * @param firstNameDog
   */
  public void setFirstNameDog(String firstNameDog) {
    this.firstNameDog = firstNameDog;
  }

  /**
   *
   * @return
   */
  public String getBreed() {
    return breed;
  }

  /**
   *
   * @param breed
   */
  public void setBreed(String breed) {
    this.breed = breed;
  }

  /**
   *
   * @return
   */
  public int getAgeDog() {
    return ageDog;
  }

  /**
   *
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
  public void setEnergyDog(String energyDog) {
    this.energyDog = energyDog;
  }

  /**
   *
   * @return
   */
  public String getDescriptionDog() {
    return descriptionDog;
  }

  /**
   *
   * @param descriptionDog
   */
  public void setDescriptionDog(String descriptionDog) {
    this.descriptionDog = descriptionDog;
  }

  /**
   *
   * @return
   */
  public String getPhotosDog() {
    return photosDog;
  }

  /**
   *
   * @param photosDog
   */
  public void setPhotosDog(String photosDog) {
    this.photosDog = photosDog;
  }
}