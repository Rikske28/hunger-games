package com.company;

import java.util.Random;

public class GameController {

    int endOfDayCounter;
    BasicContestant[] contestantArray = new BasicContestant[24];
    BattleManager battle = new BattleManager();


    public GameController() {
        int districtCounter = 1;

        //creating district contestants to an array of contestants
        for (int x = 0; x < 18; x++) {
           // challangeList.add( new districtContestant());
            contestantArray[x] = new DistrictContestant();
        }

        //creating a quater career contestants
        for (int x = 18; x < 24; x++) {
           // challangeList.add( new careerContestant());
            contestantArray[x] = new CareerContestant();
        }

        // making half of the contestants male / female && determine the district
        for (int x = 0; x < 24; x++) {

            if (x % 2 == 0) {
                contestantArray[x].setMaleOrNot(true);
                contestantArray[x].setDistrict(districtCounter);
                contestantArray[x].setHealth(100);
                contestantArray[x].setAttackLevel(2);



                contestantArray[x + 1].setMaleOrNot(false);
                contestantArray[x + 1].setDistrict(districtCounter);
                contestantArray[x + 1].setHealth(100);
                contestantArray[x + 1].setDefenseLevel(2);

                districtCounter++;
            }
        }
    }

    // starts the game
    public void gameStart(){
        System.out.println("Welcome to the 28th edition of the hunger games");
        BasicContestant firstToBattle = null;
        BasicContestant secondToBattle = null;

        //loop to a day
        //check if the contestant is dead or not
        //every player get a chance to find an item
        //every player has a chance to fight that day
        while(!gameEndEvent()){
            for(BasicContestant x : contestantArray){
                if(x.getHealth() <= 0){
                    continue;
                }
                else {
                    x.setDefenseLevel(this.getDefenseItem());
                    x.setAttackLevel(this.getAttackItem());
                    if (this.hasToBattle()) {
                        if (firstToBattle == null) {
                            firstToBattle = x;
                            continue;
                        } else if (secondToBattle == null) {
                            secondToBattle = x;
                            battle.battle(firstToBattle, secondToBattle);
                            firstToBattle = null;
                            secondToBattle = null;
                        }
                    }
                }
            }
            endOfDay();
        }
    }

    //end of day event
    public void endOfDay(){
        endOfDayCounter++;

        // set all the health of the contestants back to 100 if not dead
        for(BasicContestant x : contestantArray) {
            if (x.getHealth() > 0) {
                x.setHealth(100);
            }
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("                    End of day " + endOfDayCounter);
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------");
    }

    //check if there is only one contestant left or not and return the winner and a boolean.
    public boolean gameEndEvent(){
        int playersAboveZeroHealthsCounter = 0;
        BasicContestant winner = null;

        //if there is only one player with more than 0 health announce the winner
        for(BasicContestant x : contestantArray) {
            if (x.getHealth() > 0) {
                playersAboveZeroHealthsCounter++;
                winner = x;
            }
        }

        if(playersAboveZeroHealthsCounter == 1){
            System.out.println("----------------------------------------------------------------");
            System.out.println("        *                       *                              *                    *");
            System.out.println("                        *                               *               *               *");
            System.out.println("                *                       *                           *           *");
            System.out.println("                            The winner won on day " + endOfDayCounter);
            System.out.println("         The winner is: " + winner.toString());
            System.out.println("                            Thanks for joining Jeroens Hunger Games!");
            System.out.println("            *           *                                           *");
            System.out.println("                                *                   *                                   *");
            System.out.println("        *                               *                                       *");
            System.out.println("----------------------------------------------------------------");
            return true;
        }
        else
            {
                playersAboveZeroHealthsCounter = 0;
                winner = null;
            return false;
        }
    }

    //checks if a player has to battle or if he draws a number under the 50 it triggers true
    public boolean hasToBattle(){
        if(chance(50)){
            return true;
        }
        else {
            return false;
        }
    }

    //chance to get an attack item with value of 3
    public int getAttackItem(){
        int addAttackItem = 1;
        if(chance(20)){
            addAttackItem += 3;
        }
        return addAttackItem;
    }

    //chance to get an defense item with value of 3
    public int getDefenseItem(){
        int addDefenseItem= 0;
        if(chance(20)){
            addDefenseItem += 3;
        }
        return addDefenseItem;
    }


    //get a random number between 1 and 100 and return true if smaller than 25 and else return false
    public boolean chance(int underNumToWork) {
        Random random = new Random();
        int upperBound = 100;
        int lowerBound = 1;
        int chance = random.nextInt(upperBound - lowerBound) + lowerBound;

        if (chance < underNumToWork) {
            return true;
        } else {
            return false;
        }
    }
}
