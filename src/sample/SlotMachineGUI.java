package sample;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;


/**
 * Created by Madhawa on 5/11/2017.
 */
public class SlotMachineGUI extends Application {

    static Button butSpin, butBetOne, butBetMax, butReset, butAddcoin, butStatistics; //Buttons
    static Label image1, image2, image3, WinnerLoose,Credit,Bet,lblBet,lblCredit, Heading; //Labels
    static ImageView img1,img2,img3; //Images


    static int credit = 10;
    static int bet = 0;
    static int count = 0;
    static int winCredit = 0;
    static int lostCredit = 0;
    static int won = 0;
    static int loose = 0;
    static int neBet;


    public static void main(String[] args) {

        launch(args);
    }

    static boolean spinning = false;
    static boolean first = true;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Welcome to SLOT MACHINE"); //Setting title of the main window


        GridPane main = new GridPane();
        main.getStyleClass().add("grid");
        main.setGridLinesVisible(false);
        main.setAlignment(Pos.CENTER);
        main.setPadding(new Insets(10,10,10,10));

        // ------------- BACKGROUND IMAGE ---------------

//        Image image = new Image("Images/background.png");
//        ImageView background = new ImageView();
//        background.setImage(image);
//
//        main.getChildren().add(background);



        //================== COLUMN CONSTRAINTS ==================
        ColumnConstraints column_1 = new ColumnConstraints();
        column_1.setPercentWidth(15);

        ColumnConstraints column_2 = new ColumnConstraints();
        column_2.setPrefWidth(200);
        column_2.setMinWidth(200);

        ColumnConstraints column_4 = new ColumnConstraints();
        column_4.setPrefWidth(200);
        column_4.setMinWidth(200);

        ColumnConstraints column_6 = new ColumnConstraints();
        column_6.setPrefWidth(200);
        column_6.setMinWidth(200);

        ColumnConstraints column_7 = new ColumnConstraints();
        column_7.setPercentWidth(15);

        ColumnConstraints gaps = new ColumnConstraints();
        gaps.setMinWidth(10);
        gaps.setPrefWidth(40);

        //================== ROW CONSTRAINTS ==================
        RowConstraints row_1 = new RowConstraints();
        row_1.setPrefHeight(120);
        row_1.setMinHeight(100);

        RowConstraints row_2 = new RowConstraints();
        row_2.setPrefHeight(200);
        row_2.setMinHeight(200);

        RowConstraints row_3 = new RowConstraints();
        row_3.setPrefHeight(30);
        row_3.setMinHeight(30);

        RowConstraints row_4 = new RowConstraints();
        row_4.setPrefHeight(50);
        row_4.setMinHeight(50);

        RowConstraints row_5 = new RowConstraints();
        row_5.setPrefHeight(120);
        row_5.setMinHeight(120);

        RowConstraints row_6 = new RowConstraints();
        row_6.setPrefHeight(60);
        row_6.setMinHeight(60);

        //================== CREATING LABELS ==================
        Heading = new Label("SLOT MACHINE");
        WinnerLoose = new Label();
        Credit = new Label("CREDIT AREA");
        Bet = new Label("BET AREA");
        image1 = new Label();
        image2 = new Label();
        image3 = new Label();
        lblCredit = new Label();
        lblBet = new Label();

        //================== CREATING BUTTONS ==================
        butSpin = new Button("SPIN");
        butAddcoin = new Button("ADD COIN");
        butBetMax = new Button("BET MAX");
        butBetOne = new Button("BET ONE");
        butReset = new Button("RESET");
        butStatistics = new Button("STATISTICS");

        //================== SETTING IDs TO LABELS ==================
        Heading.setId("heading");
        WinnerLoose.setId("");
        Credit.setId("");
        Bet.setId("");

        //================== SETTING IDs TO BUTTONS ==================
        butSpin.setId("butSpin");
        butAddcoin.setId("butAddcoin");
        butBetMax.setId("butBetmax");
        butBetOne.setId("butBetone");
        butReset.setId("butReset");
        butStatistics.setId("butStatistics");

        //================== SETTING IMAGES ==================
        img1=new ImageView();
        img1.setImage(new Image("Images/bell.png"));
        image1.setGraphic(img1);
        img2=new ImageView();
        img2.setImage(new Image("Images/lemon.png"));
        image2.setGraphic(img2);
        img3=new ImageView();
        img3.setImage(new Image("Images/cherry.png"));
        image3.setGraphic(img3);

        Thread t1 = new Thread(new Spin(img1,img2,img3));

        ///================== ALIGNING IMAGES ==================
//        background.setFitHeight(700);
//        background.setFitWidth(1000);

        GridPane.setConstraints(image1,1,1);
        img1.setFitHeight(175);
        img1.setFitWidth(175);

        GridPane.setConstraints(image2,3,1);
        img2.setFitHeight(175);
        img2.setFitWidth(175);

        GridPane.setConstraints(image3,5,1);
        img3.setFitHeight(175);
        img3.setFitWidth(175);

        //================== ALIGNING LABELS ==================
        WinnerLoose.setPadding(new Insets(55));
        GridPane.setConstraints(WinnerLoose,3,2,5,1);
        GridPane.setConstraints(Credit,0,3,1,1);
        GridPane.setConstraints(Bet,6,3,1,1);
        GridPane.setConstraints(lblCredit,0,4,1,1);
        GridPane.setConstraints(lblBet,6,4,1,1);
        GridPane.setConstraints(Heading,2,0,5,1);

        //================== ALIGNING BUTTONS ==================
        GridPane.setConstraints(butSpin,3,4,1,1);
        butSpin.setPrefSize(100,100);

        butAddcoin.setPrefSize(150,10);
        GridPane.setConstraints(butAddcoin,1,5,1,1);

        butBetMax.setPrefSize(150,10);
        GridPane.setConstraints(butBetMax,5,3,1,1);

        butBetOne.setPrefSize(150,10);
        GridPane.setConstraints(butBetOne,1,3,1,1);

        butReset.setPrefSize(150,10);
        GridPane.setConstraints(butReset,3,5,1,1);

        butStatistics.setPrefSize(150,10);
        GridPane.setConstraints(butStatistics,5,5,1,1);

        main.setHalignment(butSpin, HPos.CENTER);
        main.setHalignment(butAddcoin, HPos.CENTER);
        main.setHalignment(butBetMax, HPos.CENTER);
        main.setHalignment(butBetOne, HPos.CENTER);
        main.setHalignment(butReset, HPos.CENTER);
        main.setHalignment(butStatistics, HPos.CENTER);
        main.setHalignment(lblBet, HPos.CENTER);
        main.setHalignment(lblCredit, HPos.CENTER);
        main.setHalignment(Credit,HPos.CENTER);
        main.setHalignment(Bet,HPos.CENTER);
//        main.setHalignment(Heading,HPos.CENTER);



        //================== RESET BUTTON FUNCTION ==================
        butReset.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                credit = 10;
                //credit+=bet;
                bet = 0;
                won = 0;
                loose = 0;
                count = 0;
                lblCredit.setText(Integer.toString(credit));
                lblBet.setText(Integer.toString(bet));
            }
        });

        //================== ADD COIN BUTTON FUNCTION ==================
        butAddcoin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                credit+=1;
                lblCredit.setText(Integer.toString(credit));
            }
        });

        //================== SPIN BUTTON FUNCTION ==================
        butSpin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //  spinnin =true;

                if (bet > 0 && !spinning && first) {
                    WinnerLoose.setText("SPINNING");
                    //System.out.println("Threads are started");
                    // spinnin = true;
                    System.out.println("spin button");
                    t1.start();
                    first = false;


                } else if (!first && bet > 0) {
                    WinnerLoose.setText("SPINNING");
                    t1.resume();



                } else {
                    Alert credAlert = new Alert(Alert.AlertType.WARNING);
                    credAlert.setHeaderText("!!!!!!!!!!! ALERT !!!!!!!!!!!");
                    credAlert.setContentText("YOU RAN OUT OF CREDITS");
                    credAlert.show();
                }

                //bet = 0;
                count++;
            }

        });


        //================== STOP SPINNING BUTTON FUNCTION - IMAGE 1 ==================
        image1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (img1.getImage()==img2.getImage() || img2.getImage()==img3.getImage() || img1.getImage() == img3.getImage() || img1.getImage()==img2.getImage() && img2.getImage()==img3.getImage()){
                    WinnerLoose.setText("YOU WON");

                    if (img1.getImage()==img2.getImage() && img2.getImage()==img3.getImage()){
                        for (Symbol j : Reel.symbols)
                            if (j.getImg() == img1.getImage()){
                                credit += bet * j.getImageValue();
                                winCredit = bet * j.getImageValue();
                                lblCredit.setText(Integer.toString(credit));
                            }

                    }else if (img1.getImage() == img2.getImage()){
                        for (Symbol j : Reel.symbols)
                            if (j.getImg() == img1.getImage()){
                                credit += bet * j.getImageValue();
                                lblCredit.setText(Integer.toString(credit));
                            }

                    }else if (img2.getImage() == img3.getImage()){
                        for (Symbol j : Reel.symbols)
                            if (j.getImg() == img2.getImage()){
                                credit += bet * j.getImageValue();
                                lblCredit.setText(Integer.toString(credit));
                            }

                    }else if (img1.getImage() == img3.getImage()){
                        for (Symbol j : Reel.symbols)
                            if (j.getImg() == img1.getImage()){
                                credit += bet * j.getImageValue();
                                lblCredit.setText(Integer.toString(credit));
                            }
                    }

                    neBet = 0;
                    lblBet.setText(Integer.toString(neBet));
                    won++;


                }else{
                    WinnerLoose.setText("YOU LOST");
                    neBet = 0;
                    lblBet.setText(Integer.toString(neBet));
                    loose++;
                    count++;
                    System.out.println(bet);
                    lostCredit = bet;
                    System.out.println(lostCredit);

                }
                System.out.println("image 1");
                t1.suspend();

            }
        });

        //================== STOP SPINNING BUTTON FUNCTION - IMAGE 2 ==================
        image2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (img1.getImage()==img2.getImage() || img2.getImage()==img3.getImage() || img1.getImage() == img3.getImage() || img1.getImage()==img2.getImage() && img2.getImage()==img3.getImage()){
                    WinnerLoose.setText("YOU WON");

                    if (img1.getImage()==img2.getImage() && img2.getImage()==img3.getImage()){
                        for (Symbol j : Reel.symbols)
                            if (j.getImg() == img1.getImage()){
                                credit += bet * j.getImageValue();
                                winCredit = bet * j.getImageValue();
                                lblCredit.setText(Integer.toString(credit));
                            }

                    }else if (img1.getImage() == img2.getImage()){
                        for (Symbol j : Reel.symbols)
                            if (j.getImg() == img1.getImage()){
                                credit += bet * j.getImageValue();
                                lblCredit.setText(Integer.toString(credit));
                            }

                    }else if (img2.getImage() == img3.getImage()){
                        for (Symbol j : Reel.symbols)
                            if (j.getImg() == img2.getImage()){
                                credit += bet * j.getImageValue();
                                lblCredit.setText(Integer.toString(credit));
                            }

                    }else if (img1.getImage() == img3.getImage()){
                        for (Symbol j : Reel.symbols)
                            if (j.getImg() == img1.getImage()){
                                credit += bet * j.getImageValue();
                                lblCredit.setText(Integer.toString(credit));
                            }
                    }

                    neBet = 0;
                    lblBet.setText(Integer.toString(neBet));
                    won++;


                }else{
                    WinnerLoose.setText("YOU LOST");
                    neBet = 0;
                    lblBet.setText(Integer.toString(neBet));
                    loose++;
                    count++;
                    System.out.println(bet);
                    lostCredit = bet;
                    System.out.println(lostCredit);

                }
                System.out.println("image 1");
                t1.suspend();

            }
        });

        //================== STOP SPINNING BUTTON FUNCTION - IMAGE 3 ==================
        image3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if (img1.getImage()==img2.getImage() || img2.getImage()==img3.getImage() || img1.getImage() == img3.getImage() || img1.getImage()==img2.getImage() && img2.getImage()==img3.getImage()){
                    WinnerLoose.setText("YOU WON");

                    if (img1.getImage()==img2.getImage() && img2.getImage()==img3.getImage()){
                        for (Symbol j : Reel.symbols)
                            if (j.getImg() == img1.getImage()){
                                credit += bet * j.getImageValue();
                                winCredit = bet * j.getImageValue();
                                lblCredit.setText(Integer.toString(credit));
                            }

                    }else if (img1.getImage() == img2.getImage()){
                        for (Symbol j : Reel.symbols)
                            if (j.getImg() == img1.getImage()){
                                credit += bet * j.getImageValue();
                                lblCredit.setText(Integer.toString(credit));
                            }

                    }else if (img2.getImage() == img3.getImage()){
                        for (Symbol j : Reel.symbols)
                            if (j.getImg() == img2.getImage()){
                                credit += bet * j.getImageValue();
                                lblCredit.setText(Integer.toString(credit));
                            }

                    }else if (img1.getImage() == img3.getImage()){
                        for (Symbol j : Reel.symbols)
                            if (j.getImg() == img1.getImage()){
                                credit += bet * j.getImageValue();
                                lblCredit.setText(Integer.toString(credit));
                            }
                    }

                    neBet = 0;
                    lblBet.setText(Integer.toString(neBet));
                    won++;


                }else{
                    WinnerLoose.setText("YOU LOST");
                    neBet = 0;
                    lblBet.setText(Integer.toString(neBet));
                    loose++;
                    count++;
                    System.out.println(bet);
                    lostCredit = bet;
                    System.out.println(lostCredit);

                }
                System.out.println("image 1");
                t1.suspend();

            }
        });

        //================== BET ONE COIN BUTTON FUNCTION ==================
        butBetOne.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (credit - 1 >= 0){
                    credit-=1;
                    //winningCredit-=1;
                    bet+=1;
                    //lostCrd += bet;

                    lblCredit.setText(Integer.toString(credit));
                    lblBet.setText(Integer.toString(bet));
                }else{
                    Alert credAlert = new Alert(Alert.AlertType.WARNING);
                    credAlert.setHeaderText("!!!!!!!!!!! ALERT !!!!!!!!!!!");
                    credAlert.setContentText("YOU RAN OUT OF CREDITS");
                    credAlert.show();
                }
            }
        });

        //================== BET MAXIMUM(3 COINS) BUTTON FUNCTION ==================
        butBetMax.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (credit - 1 >= 1){
                    credit-=3;
                    bet+=3;

                    lblCredit.setText(Integer.toString(credit));
                    lblBet.setText(Integer.toString(bet));
                }else {
                    Alert maxCreditAlert = new Alert(Alert.AlertType.WARNING);
                    maxCreditAlert.setHeaderText("!!!!!!!!!!! ALERT !!!!!!!!!!!");
                    maxCreditAlert.setContentText("YOU RAN OUT OF CREDITS");
                    maxCreditAlert.show();
                }
            }
        });

        //================== STATISTICS BUTTON FUNCTION - OPEN STATISTICS WINDOW ==================
        butStatistics.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {


                Statistics.display();

            }
        });

        //------------------------------------------------------------------------------------------
        main.getRowConstraints().addAll(row_1,row_2,row_3,row_4,row_5,row_6);
        main.getColumnConstraints().addAll(column_1,column_2,gaps,column_4,gaps,column_6,column_7);
        main.getChildren().addAll(WinnerLoose,image1,image2,image3,butBetOne,butBetMax,butSpin,butReset,butStatistics,butAddcoin,Credit,Bet,lblCredit,lblBet,Heading);
        Scene scene1 = new Scene(main,1280,720);

        String css =this.getClass().getResource("style.css").toExternalForm();
        scene1.getStylesheets().add(css);
        primaryStage.setScene(scene1);
        primaryStage.show();


    }

}
