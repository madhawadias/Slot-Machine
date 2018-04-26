package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Statistics {

    static Label lblWin,lblLoose,lblwinAverage,lbllostAverage,Win,Loose,WinAverage,LostAverage; //labels
    static Button btnSave; //buttons

    public static void display() {

        Stage stage = new Stage();
        stage.setTitle("Statistics"); //Title of the statistics window

        GridPane stat = new GridPane(); //Creating a gridpane object
        stat.setId("statistics"); //Setting an ID to the grid pane
        stat.setGridLinesVisible(false);
        stat.setAlignment(Pos.CENTER); //Alligning the gridpane
        stat.setPadding(new Insets(10, 10, 10, 10));

        //================== CREATING LABELS ==================
        lblLoose = new Label("LOST ");
        lblWin = new Label("WON ");
        lbllostAverage = new Label("AVERAGE OF LOSES");
        lblwinAverage = new Label("AVERAGE OF WiNS");
        Win = new Label();
        Loose = new Label();
        WinAverage = new Label();
        LostAverage = new Label();

        //================== CREATING BUTTONS ==================
        btnSave = new Button("SAVE STATS");

        //-------------------------------------------------------------------------
        lblWin.setPadding(new Insets(10,40,10,90));
        lblwinAverage.setPadding(new Insets(10,40,10,40));
        lblLoose.setPadding(new Insets(10,40,10,90));
        lbllostAverage.setPadding(new Insets(10,40,10,40));
        //-------------------------------------------------------------------------


        //================== SETTING IDs ==================
        lblWin.setId("lblwin");
        lblLoose.setId("lblLoose");
        lblwinAverage.setId("lblwinAverage");
        lbllostAverage.setId("lbllostAverage");
        Win.setId("win");
        Loose.setId("loose");
        WinAverage.setId("winAverage");
        LostAverage.setId("lostAverage");
        btnSave.setId("butSave");


        //================== COLUMN CONSTRAINTS ==================
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(60);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(60);

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(60);

        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(60);

        //================== ROW CONSTRAINTS ==================
        RowConstraints rw1 = new RowConstraints();
        rw1.setPrefHeight(300);
        rw1.setMinHeight(300);

        RowConstraints rw2 = new RowConstraints();
        rw2.setPrefHeight(80);
        rw2.setMinHeight(75);

        RowConstraints rw3 = new RowConstraints();
        rw3.setPrefHeight(80);
        rw3.setMinHeight(75);

        RowConstraints rw4 = new RowConstraints();
        rw4.setPrefHeight(50);
        rw4.setMinHeight(50);

        RowConstraints rw5 = new RowConstraints();
        rw5.setPrefHeight(80);
        rw5.setMinHeight(75);

        GridPane.setConstraints(lblWin,0,1);
        GridPane.setConstraints(Win,1,1,1,1);
        GridPane.setConstraints(lblwinAverage,0,2);
        GridPane.setConstraints(WinAverage,1,2,1,1);
        GridPane.setConstraints(lblLoose,2,1);
        GridPane.setConstraints(Loose,3,1,1,1);
        GridPane.setConstraints(lbllostAverage,2,2);
        GridPane.setConstraints(LostAverage,3,2,1,1);
        GridPane.setConstraints(btnSave,1,4,2,1);


        stat.setHalignment(btnSave, HPos.CENTER);
        stat.setHalignment(Win, HPos.CENTER);
        stat.setHalignment(WinAverage, HPos.CENTER);
        stat.setHalignment(Loose, HPos.CENTER);
        stat.setHalignment(LostAverage, HPos.CENTER);

        Win.setText(Integer.toString(SlotMachineGUI.won)); //Setting a text value to the Win label
        Loose.setText(Integer.toString(SlotMachineGUI.loose)); //Setting a text value to the Loose label
        double lostAvg = SlotMachineGUI.lostCredit/(SlotMachineGUI.winCredit+SlotMachineGUI.lostCredit); //Calculating average
        LostAverage.setText(Double.toString(lostAvg));
        System.out.println(lostAvg);


        //================== SAVE STATISTICS TO A TEXT FILE ==================
        btnSave.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String fileName = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
                try (FileWriter fw = new FileWriter(new File(fileName))){
                    try (PrintWriter pw = new PrintWriter(fw, true)){

                        pw.println("Wins : " + SlotMachineGUI.won + "  Loses : " + SlotMachineGUI.loose);

                    }

                }catch (IOException e2){
                        e2.printStackTrace();
                }

            }
        });


        stage.setTitle("Statistics"); //setting a title to the statistics window

        PieChart pieChart = new PieChart(); //Creating PieChart object

        PieChart.Data slice1 = new PieChart.Data("Wins", SlotMachineGUI.won);
        PieChart.Data slice2 = new PieChart.Data("Loses"  , SlotMachineGUI.loose);

        pieChart.getData().add(slice1);
        pieChart.getData().add(slice2);

        VBox vbox = new VBox(pieChart);
        stat.add(vbox,1,0,2,1); //Positioning the PieChart

        stat.getColumnConstraints().addAll(col1, col2, col3, col4);
        stat.getRowConstraints().addAll(rw1, rw2, rw3, rw4, rw5);
        stat.getChildren().addAll(lblWin,Win,lblwinAverage,WinAverage,lblLoose,Loose,lbllostAverage,LostAverage,btnSave);


        Scene scene2 = new Scene(stat, 1280,720);
        scene2.getStylesheets().add(Statistics.class.getResource("style.css").toExternalForm()); //Assigning external stylesheet
        stage.setScene(scene2);
        stage.show();

    }
}