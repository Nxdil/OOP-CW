import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface LeagueManager {
    void addClub(String clubName, String clubLocation, String owner, String clubLeader);
    void deleteClub(String clubName);
    void displayStats(String clubName);
    void displayTable();
    void save() throws IOException;
    void load();
    void addMatchDetails(Dates datePlayed, FootballClub club1, int club1Score, FootballClub club2, int club2Score);
}
