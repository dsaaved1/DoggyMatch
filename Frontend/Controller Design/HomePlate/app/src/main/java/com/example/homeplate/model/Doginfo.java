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

    /**
     * Basic constructor
     */
    public Doginfo() {
    }

    /**
     * gets the dogs first name
     * @return String of the name
     */
    public String getFirstNameDog() {
        return firstNameDog;
    }

    /**
     * Sets the dogs First name
     * @param firstNameDog
     */
    public void setFirstNameDog(String firstNameDog) {
        this.firstNameDog = firstNameDog;
    }

    /**
     * gets the breed of the dog
     * @return String Breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Sets breed of current dog
     * @param breed
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Gets the current dogs age
     * @return age
     */
    public int getAgeDog() {
        return ageDog;
    }

    /**
     * sets the age of current dog
     * @param ageDog
     */
    public void setAgeDog(int ageDog) {
        this.ageDog = ageDog;
    }

    /**
     * gets the dogs description
     * @return string description
     */
    public String getDescriptionDog() {
        return descriptionDog;
    }

    /**
     * Sets current dogs description
     * @param descriptionDog
     */
    public void setDescriptionDog(String descriptionDog) {
        this.descriptionDog = descriptionDog;
    }

    /**
     * gets energy level of current dog
     * @return energy level
     */
    public String getEnergyDog() {
        return energyDog;
    }

    /**
     * sets the energy level
     * @param energyDog
     */
    public void setEnergyDog(String energyDog) {
        this.energyDog = energyDog;
    }

    /**
     * gets the gender of current dog
     * @return string gender
     */
    public String getGenderDog() {
        return genderDog;
    }

    /**
     * sets current dogs gender
     * @param genderDog
     */
    public void setGenderDog(String genderDog) {
        this.genderDog = genderDog;
    }

    /**
     * gets current dogs photo
     * @return string of photo
     */
    public String getPhotosDog() {
        return photosDog;
    }

    /**
     * sets current dogs photo
     * @param photosDog
     */
    public void setPhotosDog(String photosDog) {
        this.photosDog = photosDog;
    }
}
