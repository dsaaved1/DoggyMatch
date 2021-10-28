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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstNameDog() {
    return firstNameDog;
  }

  public void setFirstNameDog(String firstNameDog) {
    this.firstNameDog = firstNameDog;
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

  public void setEnergyDog(String energyDog) {
    this.energyDog = energyDog;
  }

  public String getDescriptionDog() {
    return descriptionDog;
  }

  public void setDescriptionDog(String descriptionDog) {
    this.descriptionDog = descriptionDog;
  }

  public String getPhotosDog() {
    return photosDog;
  }

  public void setPhotosDog(String photosDog) {
    this.photosDog = photosDog;
  }
}