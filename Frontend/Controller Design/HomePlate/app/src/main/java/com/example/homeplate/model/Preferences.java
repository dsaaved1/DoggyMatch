package com.example.homeplate.model;

/**
 * Users preferences
 * @author Mark Gores
 */
public class Preferences {
    private String breed;
    private int ageDog;
    private String genderDog;
    private String energyDog;
    private boolean dogPark;
    private boolean atHome;

    /**
     * basic constructor
     */
    public Preferences() {
    }

    /**
     * gets breed preference
     * @return breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * sets breed preference
     * @param breed
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * gets dog age preference
     * @return age
     */
    public int getAgeDog() {
        return ageDog;
    }

    /**
     * sets dog age preference
     * @param ageDog
     */
    public void setAgeDog(int ageDog) {
        this.ageDog = ageDog;
    }

    /**
     * gets dog gender preference
     * @return gender
     */
    public String getGenderDog() {
        return genderDog;
    }

    /**
     * sets dog gender preference
     * @param genderDog
     */
    public void setGenderDog(String genderDog) {
        this.genderDog = genderDog;
    }

    /**
     * gets dog energy preference
     * @return dog energy
     */
    public String getEnergyDog() {
        return energyDog;
    }

    /**
     * sets dog energy level preference
     * @param energyDog
     */
    public void setEnergyDog(String energyDog) {
        this.energyDog = energyDog;
    }

    /**
     * get dog park preference
     * @return boolean dogpark
     */
    public boolean isDogPark() {
        return dogPark;
    }

    /**
     * sets dog park preference
     * @param dogPark
     */
    public void setDogPark(boolean dogPark) {
        this.dogPark = dogPark;
    }

    /**
     * gets stay at home preference
     * @return at home preference
     */
    public boolean isAtHome() {
        return atHome;
    }

    /**
     * sets at home preference
     * @param atHome
     */
    public void setAtHome(boolean atHome) {
        this.atHome = atHome;
    }
}
