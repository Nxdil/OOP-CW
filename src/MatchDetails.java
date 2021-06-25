import java.io.Serializable;



public class MatchDetails implements Serializable {
    private Dates datePlayed;
    private FootballClub club1;
    private FootballClub club2;
    private int club1Score;
    private int club2Score;

    public MatchDetails(Dates datePlayed, FootballClub club1, FootballClub club2, int club1Score, int club2Score) {
        this.datePlayed = datePlayed;
        this.club1 = club1;
        this.club2 = club2;
        this.club1Score = club1Score;
        this.club2Score = club2Score;
    }

    public Dates getDatePlayed() {
        return datePlayed;
    }

    public void setDatePlayed(Dates datePlayed) {
        this.datePlayed = datePlayed;
    }

    public FootballClub getClub1() {
        return club1;
    }

    public void setClub1(FootballClub club1) {
        this.club1 = club1;
    }

    public FootballClub getClub2() {
        return club2;
    }

    public void setClub2(FootballClub club2) {
        this.club2 = club2;
    }

    public int getClub1Score() {
        return club1Score;
    }

    public void setClub1Score(int club1Score) {
        this.club1Score = club1Score;
    }

    public int getClub2Score() {
        return club2Score;
    }

    public void setClub2Score(int club2Score) {
        this.club2Score = club2Score;
    }
}

