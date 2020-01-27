package test;

import com.company.BasicContestant;
import com.company.CareerContestant;
import com.company.DistrictContestant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContestantsTest {

    CareerContestant careerTest = new CareerContestant();
    DistrictContestant districtTest = new DistrictContestant();

    @BeforeEach
    void setup() {
    careerTest.setHealth(100);
    districtTest.setHealth(100);
    }

    @Test
    void careerGettingHit(){
    careerTest.hit(100);
    assertEquals(0, careerTest.getHealth());
    }

    @Test
    void districtGettingHit(){
        districtTest.hit(100);
        assertEquals(60, districtTest.getHealth());
    }

    @Test
    void CareerwithHighDefenseGetHit(){
        careerTest.setDefenseLevel(100);
        careerTest.hit(100);
        assertEquals(98, careerTest.getHealth());
    }
}
