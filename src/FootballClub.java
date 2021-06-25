import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportClub implements Serializable{
    private int seasonWins;             //  Number of wins.
    private int seasonDraws;            //  Number of Draws.
    private int seasonDefeats;          //  Number of Defeats.
    private int goalsReceived;          //  Number of goals received.
    private int goalsScored;            //  Number of goals scored.
    private int currentClubScore;       //  The number of points that a club currently has.
    private int noOfMatchesPlayed;      //  The number of matches played should also be included.




    public FootballClub(String clubName, String clubLocation, String owner, String clubLeader) {
        super(clubName, clubLocation, owner, clubLeader);

    }
    public FootballClub() {

    }

    @Override
    public String toString() {
        return this.getClubName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FootballClub)) return false;
        if (!super.equals(o)) return false;
        FootballClub that = (FootballClub) o;
        return seasonWins == that.seasonWins &&
                seasonDraws == that.seasonDraws &&
                seasonDefeats == that.seasonDefeats &&
                goalsReceived == that.goalsReceived &&
                goalsScored == that.goalsScored &&
                currentClubScore == that.currentClubScore &&
                noOfMatchesPlayed == that.noOfMatchesPlayed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seasonWins, seasonDraws, seasonDefeats, goalsReceived, goalsScored, currentClubScore, noOfMatchesPlayed);
    }


    public FootballClub(int seasonWins, int seasonDraws, int seasonDefeats, int goalsReceived, int goalsScored, int currentClubScore, int noOfMatchesPlayed) {
        this.seasonWins = seasonWins;
        this.seasonDraws = seasonDraws;
        this.seasonDefeats = seasonDefeats;
        this.goalsReceived = goalsReceived;
        this.goalsScored = goalsScored;
        this.currentClubScore = currentClubScore;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    public int getSeasonWins() {
        return seasonWins;
    }

    public void setSeasonWins(int seasonWins) {
        this.seasonWins = seasonWins;
    }

    public int getSeasonDraws() {
        return seasonDraws;
    }

    public void setSeasonDraws(int seasonDraws) {
        this.seasonDraws = seasonDraws;
    }

    public int getSeasonDefeats() {
        return seasonDefeats;
    }

    public void setSeasonDefeats(int seasonDefeats) {
        this.seasonDefeats = seasonDefeats;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getCurrentClubScore() {
        return currentClubScore;
    }

    public void setCurrentClubScore(int currentClubScore) {
        this.currentClubScore = currentClubScore;
    }

    public int getNoOfMatchesPlayed() {
        return noOfMatchesPlayed;
    }

    public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }


}
