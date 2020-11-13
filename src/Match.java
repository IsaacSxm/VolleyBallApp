public class Match {
    private int matchNumber;
    private Team homeTeam;
    private Team awayTeam;
    private int homeTeamPoints;
    private int awayTeamPoints;

    /**
     * This initialises the match
     * @param matchNumber takes an integer for match number
     * @param homeTeam takes a Team class as a national team
     * @param awayTeam takes a Team as international team
     */
    public Match(int matchNumber, Team homeTeam, Team awayTeam) {
        setMatchNumber(matchNumber);
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.awayTeamPoints = 0;
        this.homeTeamPoints = 0;
    }

    public int getAwayTeamPoints() {
        return awayTeamPoints;
    }

    public void setAwayTeamPoints(int awayTeamPoints) {
        this.awayTeamPoints = awayTeamPoints;
    }

    public int getHomeTeamPoints() {
        return homeTeamPoints;
    }

    public void setHomeTeamPoints(int homeTeamPoints) {
        this.homeTeamPoints = homeTeamPoints;
    }

    public Team getHomeTeam() {
        return this.homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return this.awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getMatchNumber()
    {
        return this.matchNumber;
    }

    public void setMatchNumber(int newNumber)
    {
        if(!(newNumber <= 0))
            this.matchNumber = newNumber;
    }

    public void setPoints(int nationalPts, int internationalPts)
    {
            this.setAwayTeamPoints(nationalPts);
            this.setHomeTeamPoints(internationalPts);
    }

    /**
     * This method first checks if national and international teams have points greater or equal to 1 then get the points
     * @return Returns a String containing team name and points difference. Also a default string.
     */
    public String getMatchPoints()
    {
        if (this.awayTeamPoints >= 1 || this.homeTeamPoints >= 1)
        {
            return homeTeam.getTeamName() +" : "+ awayTeamPoints + " - " + homeTeamPoints + " : " + awayTeam.getTeamName();
        }
        return null;
    }

    /**
     * This gets the winner and loser of a particular match.
     * @return  Returns String indicating winner team name and points. Also team name of loser with points.
     */
    public String getMatchDetails()
    {
        if(getWinner() != null){
            return getMatchPoints() + "\nWinner is " + getWinner().getTeamName() + " : " + (isWinnerInternational()? homeTeamPoints : awayTeamPoints) + "\n" + "Loser is " + getLoser().getTeamName() + " : "+ (isWinnerInternational()? awayTeamPoints : homeTeamPoints);

        }else{
            return "No winner or loser yet.";
        }
    }

    /**
     * This method gets the winner of a particular of match. It first checks if team points is >= 25 & if there is a point difference of >= 2
     * @return Returns a Team object representing the winner.
     */
    public Team getWinner()
    {
        if (this.awayTeamPoints >= 25 && this.awayTeamPoints - this.homeTeamPoints >= 2)
        {
            return this.homeTeam;
        }
        else if (this.homeTeamPoints >= 25 && this.homeTeamPoints - this.awayTeamPoints >= 2)
        {
            return this.awayTeam;
        }
        return null;
    }

    public Team getLoser()
    {
        if (!(this.awayTeamPoints >= 25 && this.awayTeamPoints - this.homeTeamPoints >= 2))
        {
            return this.homeTeam;
        }
        else if (!(this.homeTeamPoints >= 25 && this.homeTeamPoints - this.awayTeamPoints > 2))
        {
            return this.awayTeam;
        }
        return null;
    }

    public boolean isWinnerInternational(){
        return this.getWinner() instanceof InternationalTeam;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchNumber=" + matchNumber +
                ", nationalTeam=" + homeTeam +
                ", internationalTeam=" + awayTeam +
                '}';
    }
}
