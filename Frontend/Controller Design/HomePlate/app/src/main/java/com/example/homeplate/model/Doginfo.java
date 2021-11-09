package com.example.homeplate.model;

/**
 * All of the dogs information
 * @author Mark Gores
 */
public class Doginfo {
    private String firstNameDog;
    private String breed;
    int ageDog;
    private String descriptionDog;
    private String energyDog;
    private String genderDog;
    private String photosDog;

    public Doginfo() {
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

    public String getDescriptionDog() {
        return descriptionDog;
    }

    public void setDescriptionDog(String descriptionDog) {
        this.descriptionDog = descriptionDog;
    }

    public String getEnergyDog() {
        return energyDog;
    }

    public void setEnergyDog(String energyDog) {
        this.energyDog = energyDog;
    }

    public String getGenderDog() {
        return genderDog;
    }

    public void setGenderDog(String genderDog) {
        this.genderDog = genderDog;
    }

    public String getPhotosDog() {
        return photosDog;
    }

    public void setPhotosDog(String photosDog) {
        this.photosDog = photosDog;
    }
}
