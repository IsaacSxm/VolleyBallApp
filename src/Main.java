public class Main {

    public static void main(String[] args) {

        //Creating national teams
        Team team = new Team("South Africa");
        Team team1 = new Team("Netherlands");
        Team team2 = new Team ("Ghana");
        Team team3 = new Team("Japan");

        //Creating International teams
        InternationalTeam internationalTeam = new InternationalTeam("Kenya");
        InternationalTeam internationalTeam1 = new InternationalTeam("Belgium");
        InternationalTeam internationalTeam2 = new InternationalTeam("Nigeria");
        InternationalTeam internationalTeam3 = new InternationalTeam("Korea");

        VolleyBall volleyBall = new VolleyBall();

        //Creating matches
        Match match1 = new Match(1, team, internationalTeam);
        Match match2 = new Match(2,team1, internationalTeam1);
        Match match3 = new Match(3, team2, internationalTeam2);
        Match match4 = new Match(4,team3, internationalTeam3);
        Match match5 = new Match(5,team2, internationalTeam3);

        //Adding matches to volleyBall/ tournament
        System.out.println(volleyBall.addMatch(match1));
        volleyBall.addMatch(match2);
        volleyBall.addMatch(match3);
        volleyBall.addMatch(match4);
        volleyBall.addMatch(match5);
        System.out.println("");

        //Setting points for match
        match1.setPoints(30,33);
        match2.setPoints(40,44);
        match3.setPoints(25,21);
        match4.setPoints(-1,0);
        match5.setPoints(40,38);

        //Getting match details
        System.out.println();
        System.out.println(match1.getMatchDetails());
        System.out.println();

        //Printing match points
        System.out.println(match1.getMatchPoints());
        System.out.println(match4.getMatchPoints());
        System.out.println();

        //Printing winner of a particular match
        System.out.println(match3.getWinner());
        System.out.println();

        //Print an overview of the tournament
        System.out.println(volleyBall.getTournamentOverview());

        //Print winner of the tournament
        System.out.println(volleyBall.getWinnerOfTournament().getTeamName());

        //Print tournament points of a particular team
        System.out.println(volleyBall.getTotalPointsOfTeam(team1));
        System.out.println(volleyBall.getTotalPointsOfTeam(team2));

        System.out.println(volleyBall.getTotalPointsOfTeam(internationalTeam1));
        System.out.println(volleyBall.getTotalPointsOfTeam(internationalTeam2));

    }

}
