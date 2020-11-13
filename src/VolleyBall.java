import java.util.HashSet;

public class VolleyBall {
    private HashSet<Match> matchHashSet;

    public VolleyBall() {
        this.matchHashSet = new HashSet<Match>();
    }

    /**
     * This methods adds a match from the Match class to a hashset
     * @param match Match is coming from the match class
     */
    public String addMatch(Match match) {
            this.matchHashSet.add(match);
            return "Match added successfully.";
    }

    /**
     * This method displays all the matches added to the volleyball tournament
     * @return It returns a list of all matches added.
     */
    public HashSet<Match> getMatchHashSet() {
            return this.matchHashSet;
    }

    /**
     * This method gives an overview of the tournament.
     * @return It returns for each match, the match number, match points and the match details.
     */
    public String getTournamentOverview() {
        String result = "";
        for (Match match : this.matchHashSet) {
            result += "Details for Match no. " + match.getMatchNumber() + "\n" + match.getMatchDetails() + "\n" + "\n";
        }
        return result;
    }

    /**
     * This methods keeps track of tournament points won by the match winner. It adds the tournament points won by the team.
     * @param team Gives the total tournament win point of the Team
     * @return Return an integer for the number of tournament points won
     */
    public int getTotalPointsOfTeam(Team team){
        int totalPoints =0;
        for (Match matchSet1 : matchHashSet) {
            if(matchSet1.getWinner() == team){
                if(matchSet1.getMatchPoints() != null){
                    if(matchSet1 instanceof SuperMatch){
                        totalPoints += team.getTournamentPointsPerWin() * 2;
                    }else{
                        totalPoints += team.getTournamentPointsPerWin();
                    }

                }
            }
        }
        return totalPoints;
    }

    /**
     * This method finally gives the winner of the tournament. Winner of tournament is the Team with the highest tournament points.
     * @return Returns a "Team" as the champion
     */
    public Team getWinnerOfTournament() {
        Team champion = new Team(null);
        int maxScore = 0;
        if (!matchHashSet.isEmpty()) {
            for (Match matchSet1 : matchHashSet) {
                if(matchSet1.getMatchPoints() != null){
                    if(getTotalPointsOfTeam(matchSet1.getHomeTeam()) > maxScore){
                        maxScore = getTotalPointsOfTeam(matchSet1.getHomeTeam());
                        champion = matchSet1.getHomeTeam();
                    }
                    if(getTotalPointsOfTeam(matchSet1.getAwayTeam()) > maxScore){
                        maxScore = getTotalPointsOfTeam(matchSet1.getAwayTeam());
                        champion = matchSet1.getAwayTeam();
                    }
                }
            }
        }
        return champion;
    }
}


