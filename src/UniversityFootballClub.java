import java.util.Objects;

public class UniversityFootballClub extends FootballClub {
        private String universityName;      //  Name of the University.

    public UniversityFootballClub(String clubName, String clubLocation, String owner, String clubLeader, String universityName) {
        super(clubName, clubLocation, owner, clubLeader);
        this.universityName = universityName;
    }

    public UniversityFootballClub(int seasonWins, int seasonDraws, int seasonDefeats, int goalsReceived, int goalsScored, int currentClubScore, int noOfMatchesPlayed, String universityName) {
        super(seasonWins, seasonDraws, seasonDefeats, goalsReceived, goalsScored, currentClubScore, noOfMatchesPlayed);
        this.universityName = universityName;
    }

    public UniversityFootballClub(String universityName) {
        super();
        this.universityName = universityName;
    }




    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), universityName);
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
