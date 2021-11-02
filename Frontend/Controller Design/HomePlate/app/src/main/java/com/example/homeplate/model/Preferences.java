package com.example.homeplate.model;

public class Preferences {
    private String breed;
    private int ageDog;
    private String genderDog;
    private String energyDog;
    private boolean dogPark;
    private boolean atHome;

    public Preferences() {
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
