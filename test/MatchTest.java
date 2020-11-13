import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchTest {
    Team southAfrica = new Team("South Africa");
    Team netherlands = new Team("Netherlands");
    Team japan = new Team("Japan");


    InternationalTeam kenya = new InternationalTeam("Kenya");
    InternationalTeam belgium = new InternationalTeam("Belgium");
    InternationalTeam korea = new InternationalTeam("Korea");


    Match match1 = new Match(1, southAfrica, kenya);
    Match match2 = new Match( 2, netherlands, belgium);
    Match match4 = new Match(3, japan, korea);
    Match match5 = new Match(4, southAfrica, netherlands);



    @BeforeEach
   void setup()
    {
//        match4.addTeam();
//        match4.addTeam();


        match1.setPoints(25,20);
        match2.setPoints(27,30);

//        match4.setPoints(-1,0);
    }


    @Test
    void getMatchPoints() {
        assertEquals("South Africa : 25 - 20 : Kenya", match1.getMatchPoints());
        assertEquals("Netherlands : 27 - 30 : Japan", match2.getMatchPoints());
//        assertEquals("No points available yet.", match4.getMatchPoints());
    }

    @Test
    void getMatchDetails() {
        assertEquals("South Africa : 25 - 20 : Kenya" + "\nWinner is South Africa : 25"+"\nLoser is Kenya : 20", match1.getMatchDetails());
        assertEquals("Netherlands : 27 - 30 : Belgium" + "\nWinner is Belgium : 30"+"\nLoser is Netherlands : 27", match2.getMatchDetails());
//        assertEquals("No winner or loser yet.", match4.getMatchDetails());
    }

    @Test
    void getWinner() {
        assertEquals(southAfrica, match1.getWinner());
        assertEquals(belgium, match2.getWinner());
//        assertEquals(null, match4.getWinner());
    }

    @Test
    void getLoser() {
        assertEquals(kenya, match1.getLoser());
        assertEquals(netherlands, match2.getLoser());
//      assertEquals(match4.getLoser(), null);
    }

}