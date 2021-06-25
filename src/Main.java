import javafx.application.Application;
import javafx.stage.Stage;

import java.io.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) throws IOException {


        PremierLeagueManager PLM = new PremierLeagueManager();
        PLM.load();

        while (true) {
            Main.Ma(PLM);
        }
    }
        public static void Ma(PremierLeagueManager PLM)throws IOException{


            while (true) {
                System.out.println("\n---------------------------------------------------------------------");
                System.out.println("------------------------------Main Menu------------------------------");
                System.out.println("---------------------------------------------------------------------");
                System.out.println(
                                "Press 1 : To Add a new club\n" +
                                "press 2 : To Delete a Club\n" +
                                "press 3 : To Display Club Statistics\n" +
                                "press 4 : To Display Premier League Manager Table\n" +
                                "press 5 : To Add a Match  \n" +
                                "press 6 : To Save  \n" +
                                "press 7 : GUI  \n"
                );
                try {

                    System.out.print("Enter your Choice : ");
                    Scanner sc = new Scanner(System.in);
                    int userOption = sc.nextInt();
                    if (userOption == 1) {
                        Scanner nameSc = new Scanner(System.in);
                        Scanner locationSc = new Scanner(System.in);
                        Scanner ownerSc = new Scanner(System.in);
                        Scanner leaderSc = new Scanner(System.in);

                        System.out.println("Enter the Club Name : ");
                        String clubName = nameSc.nextLine();
                        System.out.println("Enter the Club Location : ");
                        String clubLocation = locationSc.nextLine();
                        System.out.println("Enter the Club Owner : ");
                        String owner = ownerSc.nextLine();
                        System.out.println("Enter the Club leader :");
                        String clubLeader = leaderSc.nextLine();
                        PLM.addClub(clubName, clubLocation, owner, clubLeader);

                    } else if (userOption == 2) {
                        System.out.print("Please enter the Club Name to delete : ");
                        Scanner cn = new Scanner(System.in);
                        String clubName = cn.nextLine();
                        PLM.deleteClub(clubName);
                    } else if (userOption == 3) {
                        System.out.println("-------------------------------------------------------------------");
                        System.out.println("--------------------------Club Statistics--------------------------");
                        System.out.println("-------------------------------------------------------------------");
                        System.out.print("Please enter the Club Name : ");
                        Scanner dcn = new Scanner(System.in);
                        String clubName = dcn.nextLine();
                        PLM.displayStats(clubName);
                    } else if (userOption == 4) {
                        PLM.displayTable();
                    } else if (userOption == 5) {
                        Scanner dayScanner = new Scanner(System.in);
                        Scanner scan = new Scanner(System.in);

                        // Entering Match Played date between the Clubs
                        System.out.println("Enter Date Played : ");
                        System.out.print("Day: ");
                        int day = dayScanner.nextInt();
                        System.out.print("Month: ");
                        int month = dayScanner.nextInt();
                        System.out.print("Year: ");
                        int year = dayScanner.nextInt();
                        Dates datePlayed = new Dates(day,month,year);
                        System.out.println(datePlayed);

                        // Entering Name and Score of the 1st Club.
                        System.out.println("Enter the 1st Club Name : ");
                        String club1Sc = scan.nextLine();
                        FootballClub club = null;
                        for(FootballClub clubs : PLM.getClubArrayList()){
                            if(clubs.getClubName().equals(club1Sc))
                                club = clubs;
                        }
                        System.out.println("Enter Score of " + club1Sc + ":");
                       int club1ScoreSc = Integer.parseInt(scan.nextLine());

                        // Entering Name and Score of the 2nd Club.
                        System.out.println("Enter the 2nd Club Name : ");
                        String club2Sc = scan.nextLine();
                        FootballClub club2 = null;
                        for(FootballClub clubs2 : PLM.getClubArrayList()){
                            if(clubs2.getClubName().equals(club2Sc))
                                club2 = clubs2;
                        }
                        System.out.println("Enter Score of " + club2Sc + ":");
                        int club2ScoreSc = scan.nextInt();


                        PLM.addMatchDetails(datePlayed,club,  club1ScoreSc,club2, club2ScoreSc);

                    } else if (userOption == 6) {
                        //Saving and Exiting the Program
                        PLM.save();
                    } else if (userOption == 7) {
                        //Displaying the GUI
                        Application.launch();
                    } else {
                        System.out.println("Invalid Input");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a Valid Input");
                }
            }
        }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GUI.Gui();
    }
}




