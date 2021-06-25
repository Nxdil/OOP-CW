import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class PremierLeagueManager  implements LeagueManager {

    ArrayList<FootballClub> clubArrayList = new ArrayList<>();
    ArrayList<MatchDetails>playedMatchArrayList=new ArrayList<>();

    public ArrayList<FootballClub> getClubArrayList() {
        return clubArrayList;
    }

    public void setClubArrayList(ArrayList<FootballClub> clubArrayList) {
        this.clubArrayList = clubArrayList;
    }

    public ArrayList<MatchDetails> getPlayedMatchArrayList() {
        return playedMatchArrayList;
    }

    public void setPlayedMatchArrayList(ArrayList<MatchDetails> playedMatchArrayList) {
        this.playedMatchArrayList = playedMatchArrayList;
    }

    @Override
    public void addClub(String clubName, String clubLocation, String owner, String clubLeader) {

        FootballClub footballclub = new FootballClub(clubName, clubLocation, owner, clubLeader);
        clubArrayList.add(footballclub);

        System.out.println("Club Added Successfully !");
    }

    @Override
    public void deleteClub(String clubName) {
        for(FootballClub club : clubArrayList){
                if(club.getClubName().equals(clubName)){
                    clubArrayList.remove(club);
                        System.out.println("The club " + clubName + " Has Been Removed Successfully!");
                        return;
                }
            }

    }

    @Override
    public void displayStats(String clubName) {

        for (FootballClub club : clubArrayList) {
            if (club.getClubName().equals(clubName)){
                System.out.println(" Club Name: " + club.getClubName());
                System.out.println(" Club Owner: " + club.getOwner());
                System.out.println(" Club Leader: " + club.getClubLeader());
                System.out.println(" Club Location: " + club.getClubLocation());
                System.out.println(" Club Season Wins: " + club.getSeasonWins());
                System.out.println(" Club Season Defeats: " + club.getSeasonDefeats());
                System.out.println(" Club Season Draws: " + club.getSeasonDraws());
                System.out.println(" Total Matches Played: " + club.getNoOfMatchesPlayed());
                System.out.println(" Total Goals Scored: " + club.getGoalsScored());
                System.out.println(" Total Goals Received: " + club.getGoalsReceived());
                System.out.println(" Total Club Points: " + club.getCurrentClubScore());
                return;
            }
        }
        System.out.println("Please Enter A Valid Club");
    }

    @Override
    public void displayTable() {
        Collections.sort(clubArrayList, new ComparatorC());
        System.out.println("                                             Premier League Table");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format("%-19s %-21s %-16s %-11s %-11s %-11s %-21s %-21s  %n", "Club Name    |", "Matches Played    |", "Points    |", "Wins    |", "Defeats    |", "Draws    |", "Goals Received    |", "Goals Scored    |");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        for (FootballClub club : clubArrayList) {
            System.out.format("%-24s %-19s %-15s %-12s %-11s %-14s %-21s %-21s  %n", club.getClubName(), club.getNoOfMatchesPlayed(), club.getCurrentClubScore(), club.getSeasonWins(),
                    club.getSeasonDefeats(),club.getSeasonDraws(), club.getGoalsReceived(), club.getGoalsScored());
        }
    }

    @Override
    public void save() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("SaveFile.ser");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(clubArrayList);
        outputStream.close();
        fileOutputStream.close();

        FileOutputStream MatchOutput = new FileOutputStream("MatchDetailsFile.ser");
        ObjectOutputStream output = new ObjectOutputStream(MatchOutput);
        output.writeObject(playedMatchArrayList);
        output.close();
        MatchOutput.close();

    }

    @Override
    public void load() {
        try{
            FileInputStream fileInputStream = new FileInputStream("SaveFile.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object c = objectInputStream.readObject();

            clubArrayList = (ArrayList<FootballClub>) c;

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        try{
            FileInputStream MatchOutput = new FileInputStream("MatchDetailsFile.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(MatchOutput);
            Object d = objectInputStream.readObject();
            playedMatchArrayList = (ArrayList<MatchDetails>) d;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void addMatchDetails(Dates datePlayed, FootballClub club1, int club1Score, FootballClub club2, int club2Score) {

        MatchDetails matchDetails = new MatchDetails(datePlayed, club1,club2,club1Score,club2Score);
        playedMatchArrayList.add(matchDetails);
        updateScore(matchDetails);


    }

    private void updateScore(MatchDetails matchDetails){

        matchDetails.getClub1().setNoOfMatchesPlayed(matchDetails.getClub1().getNoOfMatchesPlayed() + 1);
        matchDetails.getClub2().setNoOfMatchesPlayed(matchDetails.getClub2().getNoOfMatchesPlayed() + 1);

        matchDetails.getClub1().setGoalsScored(matchDetails.getClub1().getGoalsScored() + matchDetails.getClub1Score());
        matchDetails.getClub2().setGoalsScored(matchDetails.getClub2().getGoalsScored() + matchDetails.getClub2Score());


        matchDetails.getClub1().setGoalsReceived(matchDetails.getClub1().getGoalsReceived() + matchDetails.getClub2Score());
        matchDetails.getClub2().setGoalsReceived(matchDetails.getClub2().getGoalsReceived() + matchDetails.getClub1Score());


        if (matchDetails.getClub1Score() > matchDetails.getClub2Score()) {
            matchDetails.getClub1().setSeasonWins(matchDetails.getClub1().getSeasonWins() + 1);
            matchDetails.getClub2().setSeasonDefeats(matchDetails.getClub2().getSeasonDefeats() + 1);
            matchDetails.getClub1().setCurrentClubScore(matchDetails.getClub1().getCurrentClubScore() + 3);
        } else if (matchDetails.getClub1Score() < matchDetails.getClub2Score()) {
            matchDetails.getClub2().setSeasonWins(matchDetails.getClub2().getSeasonWins() + 1);
            matchDetails.getClub1().setSeasonDefeats(matchDetails.getClub1().getSeasonDefeats() + 1);
            matchDetails.getClub2().setCurrentClubScore(matchDetails.getClub2().getCurrentClubScore() + 3);
        } else if (matchDetails.getClub1Score() == matchDetails.getClub2Score()) {
            matchDetails.getClub1().setSeasonDraws(matchDetails.getClub1().getSeasonDraws() + 1);
            matchDetails.getClub2().setSeasonDraws(matchDetails.getClub2().getSeasonDraws() + 1);
            matchDetails.getClub1().setCurrentClubScore(matchDetails.getClub1().getCurrentClubScore() + 1);
            matchDetails.getClub2().setCurrentClubScore(matchDetails.getClub2().getCurrentClubScore() + 1);
        }

        }



}
