package com.company;

import java.util.Random;

public class BattleManager {




    //get a random number between 1 and 100 and return true if smaller than 25 and else return false
    public boolean doHit(){
        Random random = new Random();
        int upperBound = 100;
        int lowerBound = 1;
        int chance = random.nextInt(upperBound - lowerBound) + lowerBound;

        if(chance > 25){
            return true;
        }
        else{
            return false;
        }
    }

    //execute the folowing code till either one of the contestants have won the battle
    public void battle(BasicContestant a, BasicContestant b){
        while(!a.isDead() && !b.isDead()) {
            if (doHit()) {
                b.hit(a.attack());
            }
            //TODO kijk hier naar voor de fout
            else if (b.isDead()) {
            break;
            }
            else if(doHit()){
                a.hit(b.attack());
            }
        }
        if(!a.isDead()){
            System.out.println("The winner of the battle is: " + a.toString());
        }
        else {
            System.out.println("The winner of the battle is: " + b.toString());
        }
    }
}
