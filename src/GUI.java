
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Random;


public class GUI  {
    public static void Gui() {
            PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
            premierLeagueManager.load();

            Stage stage = new Stage();

            stage.setTitle("Premier League Manager");
            Pane pane = new Pane();
            // PMl Table
            TableView<FootballClub> table1 = new TableView<>();
            table1.setLayoutX(22);
            table1.setLayoutY(65);
            table1.setPrefSize(680, 350);




            Label table1lbl = new Label("Club Details");
            table1lbl.setId("lb1");
            table1lbl.setLayoutX(300);
            table1lbl.setLayoutY(30);

            // Adding Columns
            TableColumn<FootballClub, String> columnNameField = new TableColumn<>("Club Name");
            columnNameField.setMinWidth(99);
            columnNameField.setCellValueFactory(new PropertyValueFactory<>("clubName"));

            TableColumn<FootballClub, String> columnMatchesPlayed = new TableColumn<>("Matches Played");
            columnMatchesPlayed.setMinWidth(99);
            columnMatchesPlayed.setCellValueFactory(new PropertyValueFactory<>("noOfMatchesPlayed"));

            TableColumn<FootballClub, String> columnCurrentClubScore = new TableColumn<>("Club Points");
            columnCurrentClubScore.setMinWidth(99);
            columnCurrentClubScore.setCellValueFactory(new PropertyValueFactory<>("currentClubScore"));

            TableColumn<FootballClub, String> columnSeasonWins = new TableColumn<>("Wins");
            columnSeasonWins.setMinWidth(65);
            columnSeasonWins.setCellValueFactory(new PropertyValueFactory<>("seasonWins"));

            TableColumn<FootballClub, String> columnSeasonDefeats = new TableColumn<>("Defeats");
            columnSeasonDefeats.setMinWidth(65);
            columnSeasonDefeats.setCellValueFactory(new PropertyValueFactory<>("seasonDefeats"));

            TableColumn<FootballClub, String> columnSeasonDraws = new TableColumn<>("Draws");
            columnSeasonDraws.setMinWidth(65);
            columnSeasonDraws.setCellValueFactory(new PropertyValueFactory<>("seasonDraws"));

            TableColumn<FootballClub, String> columnGoalsReceived = new TableColumn<>("Goals Received");
            columnGoalsReceived.setMinWidth(99);
            columnGoalsReceived.setCellValueFactory(new PropertyValueFactory<>("goalsReceived"));

            TableColumn<FootballClub, String> columnGoalsScored = new TableColumn<>("Goals Scored");
            columnGoalsScored.setMinWidth(90);
            columnGoalsScored.setCellValueFactory(new PropertyValueFactory<>("goalsScored"));


            // Played Match Table
            TableView<MatchDetails> matchesTable = new TableView<>();
            matchesTable.getStyleClass().add("table");

            TableView<MatchDetails> playedMatch = new TableView<>();
            playedMatch.setLayoutX(742);
            playedMatch.setLayoutY(65);
            playedMatch.setPrefSize(480, 350);



            TableColumn<MatchDetails,String > matchPlayedDate = new TableColumn<>("Played Date");
            matchPlayedDate.setMinWidth(99);
            matchPlayedDate.setCellValueFactory(new PropertyValueFactory<>("datePlayed"));

            TableColumn<MatchDetails,String > matchClub1Name = new TableColumn<>("Club 1 Name");
            matchClub1Name.setMinWidth(99);
            matchClub1Name.setCellValueFactory(new PropertyValueFactory<>("club1"));

            TableColumn<MatchDetails,String > matchClub1Score = new TableColumn<>("Club 1 Score");
            matchClub1Score.setMinWidth(80);
            matchClub1Score.setCellValueFactory(new PropertyValueFactory<>("club1Score"));

            TableColumn<MatchDetails,String > matchClub2Name = new TableColumn<>("Club 2 Name");
            matchClub2Name.setMinWidth(99);
            matchClub2Name.setCellValueFactory(new PropertyValueFactory<>("club2"));

            TableColumn<MatchDetails,String > matchClub2Score = new TableColumn<>("Club 2 Score");
            matchClub2Score.setMinWidth(80);
            matchClub2Score.setCellValueFactory(new PropertyValueFactory<>("club2Score"));

            Label randomMatchLabel = new Label("Played Matches");
            randomMatchLabel.setId("lb1");
            randomMatchLabel.setLayoutX(905);
            randomMatchLabel.setLayoutY(30);




            Button randomB = new Button("Generate A Random Match");
            randomB.setId("C");
            randomB.setLayoutX(742);
            randomB.setLayoutY(450);
            randomB.setPrefHeight(50);
            randomB.setPrefWidth(480);

            randomB.setOnAction(e->{
                    try {
                            addRandomMatch();
                    } catch (IOException ioException) {
                            ioException.printStackTrace();
                    }
                    matchesTable.setItems(matchTable());
          //         matchTable();


                    table1.setItems(DisplayTable1());

            });

            Button sortByPB = new Button("Sort By Points");
            sortByPB.setLayoutX(200);
            sortByPB.setLayoutY(450);
            sortByPB.setPrefHeight(50);
            sortByPB.setPrefWidth(100);

            sortByPB.setOnAction(e->{
                    table1.getSortOrder().clear();
                    columnCurrentClubScore.setSortType(TableColumn.SortType.DESCENDING);
                    table1.getSortOrder().add(columnCurrentClubScore);
                    table1.sort();
            });

            Button sortByS = new Button("Sort By Score");
            sortByS.setLayoutX(350);
            sortByS.setLayoutY(450);
            sortByS.setPrefHeight(50);
            sortByS.setPrefWidth(100);

            sortByS.setOnAction(e->{
                    table1.getSortOrder().clear();
                    columnGoalsScored.setSortType(TableColumn.SortType.DESCENDING);
                    table1.getSortOrder().add(columnGoalsScored);
                    table1.sort();
            });



            Button refresh = new Button("Refresh");
            refresh.setLayoutX(500);
            refresh.setLayoutY(450);
            refresh.setPrefHeight(50);
            refresh.setPrefWidth(100);
            refresh.setOnAction(e -> {
                    table1.setItems(DisplayTable1());
                    matchesTable.setItems(matchTable());
                    matchTable();
            });


            //Date Text Field
            TextField dateTxt = new TextField("DD");
            dateTxt.setLayoutX(880);
            dateTxt.setLayoutY(535);
            dateTxt.setPrefHeight(40);
            dateTxt.setPrefWidth(45);
            TextField monthTxt = new TextField("MM");
            monthTxt.setLayoutX(950);
            monthTxt.setLayoutY(535);
            monthTxt.setPrefHeight(40);
            monthTxt.setPrefWidth(45);
            TextField yearTxt = new TextField("YYYY");
            yearTxt.setLayoutX(1020);
            yearTxt.setLayoutY(535);
            yearTxt.setPrefHeight(40);
            yearTxt.setPrefWidth(60);

            Button searchB = new Button("Search By Date");
            searchB.setLayoutX(742);
            searchB.setLayoutY(600);
            searchB.setPrefHeight(50);
            searchB.setPrefWidth(480);

            searchB.setOnAction(e->{
                    matchesTable.getItems().clear();
                    matchesTable.setItems(searchDate(dateTxt,monthTxt,yearTxt));

                    dateTxt.setText("");
                    monthTxt.setText("");
                    yearTxt.setText("");
            });

            pane.getChildren().addAll(table1,table1lbl,playedMatch,randomMatchLabel,randomB,dateTxt,monthTxt,yearTxt,searchB,sortByPB,sortByS,refresh);

            playedMatch.setItems(matchTable());
            playedMatch.getColumns().addAll(matchPlayedDate,matchClub1Name,matchClub1Score,matchClub2Name,matchClub2Score);


            table1.setItems(DisplayTable1());
            table1.getColumns().addAll(columnNameField,columnMatchesPlayed,columnCurrentClubScore,columnSeasonWins,columnSeasonDefeats,columnSeasonDraws,columnGoalsReceived,columnGoalsScored);
            Scene scene = new Scene(pane, 1300, 700);
            scene.getStylesheets().add(GUI.class.getResource("my.css").toExternalForm());
            stage.setScene(scene);
            stage.show();

            }

        public static ObservableList<MatchDetails> searchDate(TextField dayField,TextField monthField,TextField yearField) {
                PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
                premierLeagueManager.load();
                ObservableList<MatchDetails> matchesTable = FXCollections.observableArrayList();


                int day = Integer.parseInt(dayField.getText());
                int month = Integer.parseInt(monthField.getText());
                int year = Integer.parseInt(yearField.getText());
                Dates date = new Dates(day,month,year);
                for (MatchDetails a : premierLeagueManager.getPlayedMatchArrayList()) {
                        if (a.getDatePlayed().equals(date)){

                                matchesTable.add(a);
                        }

                }
                return matchesTable;
        }
        public static ObservableList<MatchDetails> matchTable() {
                PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
                premierLeagueManager.load();

                ObservableList<MatchDetails> matchDetails = FXCollections.observableArrayList();
                matchDetails.addAll(premierLeagueManager.getPlayedMatchArrayList());

                return matchDetails;
        }
        public static ObservableList<FootballClub> DisplayTable1() {
                PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
                premierLeagueManager.load();

                ObservableList<FootballClub> clubs = FXCollections.observableArrayList();
                clubs.addAll(premierLeagueManager.getClubArrayList());

                return clubs;
        }


                public  static void addRandomMatch() throws IOException {
                        PremierLeagueManager premierLeagueManager = new PremierLeagueManager();
                        premierLeagueManager.load();
                        Random random = new Random();

                        int rC = random.nextInt(premierLeagueManager.getClubArrayList().size());

                        int cr2 ;

                        do {
                                cr2 = random.nextInt(5);
                        } while (cr2 == rC);

                        int rGoal1 = random.nextInt(7);
                        int rGoal2 = random.nextInt(7);


                        FootballClub club1 = premierLeagueManager.getClubArrayList().get(rC);
                        FootballClub club2 = premierLeagueManager.getClubArrayList().get(cr2);


                        int day = random.nextInt(30)+1;
                        int month = random.nextInt(11)+1;
                        int year = 2021;

                        Dates date = new Dates(day,month,year);



                        premierLeagueManager.addMatchDetails(date,club1,rGoal1,club2,rGoal2);
                        premierLeagueManager.save();


                }
}



