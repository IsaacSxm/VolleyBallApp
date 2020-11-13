import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VolleyBallTest {
    Team southAfrica = new Team("South Africa");
    Team netherlands = new Team("Netherlands");
    Team ghana = new Team("Ghana");
    Team  japan = new Team("Japan");


    InternationalTeam kenya = new InternationalTeam("Kenya");
    InternationalTeam belgium = new InternationalTeam("Belgium");
    InternationalTeam nigeria = new InternationalTeam("Nigeria");
    InternationalTeam korea = new InternationalTeam("Korea");

    Match match1 = new Match(1, southAfrica, netherlands);
    Match match2 = new Match( 2, kenya, ghana);
    Match match3 = new Match(3,southAfrica, korea);
    Match match4 = new Match(4, japan, kenya);
    Match match5 = new Match(5, nigeria, japan);

    SuperMatch superMatch = new SuperMatch(6, southAfrica, japan);


    VolleyBall volleyBall = new VolleyBall();

    @BeforeEach
    void setup(){
        match1.setPoints(25,20);
        match2.setPoints(27,30);
        match3.setPoints(26, 23);
        match4.setPoints(-1,0);
        match5.setPoints(29, 35);

        volleyBall.addMatch(match1);
        volleyBall.addMatch(match2);
        volleyBall.addMatch(match3);
        volleyBall.addMatch(match4);
        volleyBall.addMatch(match5);
    }

    @Test
    void superMatchTournamentPoint() {
        superMatch.setPoints(32,25);

        volleyBall.addMatch(superMatch);

        assertEquals(6, volleyBall.getTotalPointsOfTeam(southAfrica));
        assertEquals(0, volleyBall.getTotalPointsOfTeam(japan));
    }
    @Test
    void addMatch() {
        assertEquals("Match already exist.", volleyBall.addMatch(match2));
    }

    @Test
    void getTournamentOverview() {
        assertEquals("Details for Match no. 3"+"\nGhana : 26 - 23 : Nigeria" + "\nWinner is Ghana : 26"+ "\nLoser is Nigeria : 23"+"\n"+"\n"+
            "Details for Match no. 1"+"\nSouth Africa : 25 - 20 : Kenya"+"\nWinner is South Africa : 25"+"\nLoser is Kenya : 20"+"\n"+"\n"+
            "Details for Match no. 5"+"\nGhana : 29 - 35 : Belgium"+"\nWinner is Belgium : 35"+"\nLoser is Ghana : 29"+"\n"+"\n"+
            "Details for Match no. 2"+"\nNetherlands : 27 - 30 : Belgium"+"\nWinner is Belgium : 30"+"\nLoser is Netherlands : 27"+"\n"+"\n"+
            "Details for Match no. 4"+"\nNo winner or loser yet."+"\n"+"\n", volleyBall.getTournamentOverview());
    }

    @Test
    void getTotalPointsOfTeam() {
        assertEquals(3, volleyBall.getTotalPointsOfTeam(ghana));
        assertEquals(4, volleyBall.getTotalPointsOfTeam(belgium));
    }

    @Test
    void getWinnerOfTournament() {
        assertEquals(belgium, volleyBall.getWinnerOfTournament());
    }
}