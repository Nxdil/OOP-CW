import java.io.Serializable;
import java.util.Objects;

public class SchoolFootballClub extends FootballClub implements Serializable {
        private String schoolName;          //  Name of the School.

        public SchoolFootballClub(String clubName, String clubLocation, String owner, String clubLeader, String schoolName) {
            super(clubName, clubLocation, owner, clubLeader);
            this.schoolName = schoolName;
        }

        public SchoolFootballClub(int seasonWins, int seasonDraws, int seasonDefeats, int goalsReceived, int goalsScored, int currentClubScore, int noOfMatchesPlayed, String schoolName) {
            super(seasonWins, seasonDraws, seasonDefeats, goalsReceived, goalsScored, currentClubScore, noOfMatchesPlayed);
            this.schoolName = schoolName;
        }

        public SchoolFootballClub(String schoolName) {
            this.schoolName = schoolName;
        }




    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), schoolName);
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
