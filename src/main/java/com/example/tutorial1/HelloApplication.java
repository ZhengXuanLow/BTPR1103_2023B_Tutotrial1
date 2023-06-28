package com.example.tutorial1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Text output = new Text(""); //Display
    private String name; //Store Name
    private String programme; //Store Programme
    private String outputJ1 = ""; //Store the result of CheckBox
    private String outputJ2 = ""; //Store the result of CheckBox
    private String outputOOP = ""; //Store the result of CheckBox
    private String subjectString=""; //Store the string fo the object
    private String outputString= ""; //Store the whole sentence

    private CheckBox cbJP1;
    private CheckBox cbJP2;
    private CheckBox cbOOP;
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane border = new BorderPane();
        Scene scene = new Scene(border, 1000, 240);

        //MiddleBox
        border.setCenter(output);

        //TopBox
        Label nameLabel = new Label("Name");
        TextField nameTextField = new TextField("");
        nameTextField.setOnAction(event -> {
            name = nameTextField.getText().toString();
        });
        HBox nameBox = new HBox(nameLabel,nameTextField);
        nameBox.setSpacing(10);
        nameBox.setPadding(new Insets(10));
        border.setTop(nameBox);

        //leftBox
        Label programmeLabel = new Label("Programme:");
        RadioButton rbBusinessManagement = new RadioButton("Faculty of Business Management");
        RadioButton rbArtDesign = new RadioButton("Faculty of Art and Design");
        RadioButton rbIT = new RadioButton("Faculty of Engineering & Information Technology");
        ToggleGroup tgRB = new ToggleGroup();
        rbBusinessManagement.setToggleGroup(tgRB);
        rbArtDesign.setToggleGroup(tgRB);
        rbIT.setToggleGroup(tgRB);
        rbBusinessManagement.setOnAction(event -> {
            programme = "Faculty of Business Management";
        });
        rbArtDesign.setOnAction(event -> {
            programme = "Faculty of Art & Design";
        });
        rbIT.setOnAction(event -> {
            programme = "Faculty of Engineering & Information Technology";
        });

        VBox programmeBox = new VBox(rbBusinessManagement,rbArtDesign,rbIT);
        programmeBox.setSpacing(15);
        programmeBox.setPadding(new Insets(15,10,15,10));
        border.setLeft(programmeBox);

        //RightBox
        Label subjuectLabel = new Label("Subjects");
        cbJP1 = new CheckBox("Java Programming 1");
        cbJP2 = new CheckBox("Java Programming 2");
        cbOOP = new CheckBox("Object Oriented Programing");
        VBox subjectBox = new VBox(cbJP1,cbJP2,cbOOP);

        cbJP1.setOnAction(event -> {
            if(cbJP1.isSelected())
                outputJ1 = "Java Programming 1 \n";
            else
                outputJ1 = "";
        });

        cbJP2.setOnAction(event -> {
            if(cbJP2.isSelected())
                outputJ2 = "Java Programming 2 \n";
            else
                outputJ2 = "";
        });

        cbOOP.setOnAction(event -> {
            if(cbOOP.isSelected())
                outputOOP = "Object Oriented Programming \n";
            else
                outputOOP = "";
        });

        subjectBox.setSpacing(15);
        subjectBox.setPadding(new Insets(15,10,15,10));
        border.setRight(subjectBox);

        //BottomBox
        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(event -> {
            subjectString = "\n"+outputJ1 + outputJ2 + outputOOP;
            outputString= "Name: "+name+"\nProgramme: "+programme+"\nSubject: "+subjectString;
            System.out.println(name);
            System.out.println(programme);
            System.out.println((outputString));
            output.setText(outputString);
        });

        HBox bottomBox = new HBox(submitBtn);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.setSpacing(10);
        bottomBox.setPadding(new Insets(15,10,15,10));
        border.setBottom(bottomBox);

        stage.setTitle("Welcome to SUC");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void checkSubject()
    {

    }
}