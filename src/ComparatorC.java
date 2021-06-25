import java.util.Comparator;

public class ComparatorC implements Comparator<FootballClub> {

    @Override
    public int compare(FootballClub club1, FootballClub club2) {

        if(club1.getCurrentClubScore() > club2.getCurrentClubScore())
            return -1;
        else
        if (club1.getCurrentClubScore() < club2.getCurrentClubScore())
            return 1;
        else {
            int goalDifference1 = club1.getGoalsScored()-club1.getGoalsReceived();
            int goalDifference2 = club2.getGoalsScored()-club2.getGoalsReceived();
            if(goalDifference1 > goalDifference2)
                return -1;
            else
            if(goalDifference1 < goalDifference2)
                return 1;
            else return 0;
        }

    }
}
