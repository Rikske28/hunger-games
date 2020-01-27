package com.company;

public abstract class BasicContestant {

    private int district;
    private int attackLevel;
    private int defenseLevel;
    private int health;
    private boolean male;
    private boolean isDead = false;

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public boolean isMaleOrFemale() {
        return male;
    }

    public void setMaleOrNot(boolean male) {
        this.male = male;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel += attackLevel;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel += defenseLevel;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //attack to dmg a other contestant
    public int attack(){
        int attack = 1 + this.attackLevel;
        return attack;
    }


    //dmg taken by other contestant at least 1 health
    public void hit(int hit){
        health -= hit / (1 + (0.5 * this.getDefenseLevel()));
        if(getHealth() <= 0){
            this.setDead(true);
        }
    }

    public String toString(){
        String sentence = "";
        if(isMaleOrFemale() == true){
            sentence = "male from district " + getDistrict() + " with " + getHealth() + " health and attack level is " + getAttackLevel() + " defenselevel is " + getDefenseLevel();
        }else{
            sentence = "Female from district " + getDistrict() + " with " + getHealth() + " health and attack level is " + getAttackLevel() + " defenselevel is " + getDefenseLevel();
        }
        return sentence;
    }
}
