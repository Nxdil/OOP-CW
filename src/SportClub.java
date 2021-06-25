import java.io.Serializable;
import java.util.Objects;

public class SportClub implements Serializable {
    private String clubName;            //  Name of the club.
    private String clubLocation;        //  Location of the club.
    private String owner;               //  Owner of the club.
    private String clubLeader;          //  Leader of the club.

    public SportClub(String clubName, String clubLocation, String owner, String clubLeader) {
        this.clubName = clubName;
        this.clubLocation = clubLocation;
        this.owner = owner;
        this.clubLeader = clubLeader;
    }

    public SportClub() {
    }

    @Override
    public String toString() {
        return "SportClub{" +
                "clubName='" + clubName + '\'' +
                ", clubLocation='" + clubLocation + '\'' +
                ", owner='" + owner + '\'' +
                ", clubLeader='" + clubLeader + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportClub)) return false;
        SportClub sportClub = (SportClub) o;
        return Objects.equals(clubName, sportClub.clubName) &&
                Objects.equals(clubLocation, sportClub.clubLocation) &&
                Objects.equals(owner, sportClub.owner) &&
                Objects.equals(clubLeader, sportClub.clubLeader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubName, clubLocation, owner, clubLeader);
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubLocation() {
        return clubLocation;
    }

    public void setClubLocation(String clubLocation) {
        this.clubLocation = clubLocation;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getClubLeader() {
        return clubLeader;
    }

    public void setClubLeader(String clubLeader) {
        this.clubLeader = clubLeader;
    }
}
