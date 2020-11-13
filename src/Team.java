public class Team {
    private String teamName;
    private int tournamentPointsPerWin;

    /**
     * This initialises the Team class.
     * @param teamName TeamName is a String that defines the name of team
     * tournamentPointsPerWin is the point a team gets when it wins a match. 3 points for National team and 2 points for international team.
     */
    public Team(String teamName) {
        this.teamName = teamName;
        this.tournamentPointsPerWin = 3;
    }

    public String getTeamName()
    {
        return this.teamName;
    }

    public int getTournamentPointsPerWin()
    {
        return this.tournamentPointsPerWin;
    }

    public void setTeamName( String newName)
    {
        this.teamName = newName;
    }

    public void setTournamentPointsPerWin(int tournamentPointsPerWin)
    {
        if(!(tournamentPointsPerWin <= 0))
        {
            this.tournamentPointsPerWin = tournamentPointsPerWin;
        }

    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", points=" + tournamentPointsPerWin +
                '}';
    }
}
