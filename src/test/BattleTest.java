package test;

import com.company.BasicContestant;
import com.company.BattleManager;
import com.company.CareerContestant;
import com.company.DistrictContestant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BattleTest {

    CareerContestant careerTest = new CareerContestant();
    DistrictContestant districtTest = new DistrictContestant();
    BattleManager battleTest = new BattleManager();

    @BeforeEach
    void setup() {
        //set up career & district acc
        careerTest.setHealth(100);
        careerTest.setAttackLevel(5);
        careerTest.setDefenseLevel(5);

        districtTest.setHealth(100);
        districtTest.setDefenseLevel(5);
        districtTest.setAttackLevel(5);
    }

    //check if one survivor comes out of the battle
    @Test
    void battleTestOneSurvivor() {
        battleTest.battle(careerTest, districtTest);
        assertEquals(true, (careerTest.isDead() || districtTest.isDead()));
    }

}
