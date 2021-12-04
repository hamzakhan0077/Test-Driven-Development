package com.example.javaasg3v11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        GridPane gridPane = new GridPane();
        Scene scene = new Scene(gridPane, 300, 300);
        Alert message = new Alert(Alert.AlertType.ERROR);




        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(15);
        message.initOwner(gridPane.getScene().getWindow());

        Label titleLabel = new Label("Please enter the following details:");
        Label emailLabel = new Label("Email");
        Label passwordLabel = new Label("Password");
        Label confirmPasswordLabel = new Label("Confirm Password");

        gridPane.add(titleLabel,0,0,2,1);
        gridPane.add(emailLabel,0,1);
        gridPane.add(passwordLabel,0,2);
        gridPane.add(confirmPasswordLabel,0,3);

        TextField emailField = new TextField();
        TextField passwordField = new PasswordField();
        TextField confirmPasswordField = new PasswordField();

        gridPane.add(emailField,1,1);
        gridPane.add(passwordField, 1,2);
        gridPane.add(confirmPasswordField,1,3);

        Button submitButton = new Button("Register");
        gridPane.add(submitButton,0,4,2,1);
        gridPane.setHalignment(submitButton, HPos.CENTER);


        stage.setTitle("Registration Form");
        stage.setScene(scene);
        stage.show();


        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(! emailField.getText().isEmpty()){

                    if(emailChecker(emailField.getText())){

                        if(passwordField.getText().equals(confirmPasswordField.getText())) {

                            if (passwordChecker(passwordField.getText())) {
                                message.setContentText("Welcome! " + emailField.getText() + " Your Registration has been successful");
                                message.setAlertType(Alert.AlertType.CONFIRMATION);
                                message.show();
                            } else {
                                message.setContentText("Please check your Password. The password must contain 7 characters, one Letter,One Digit and One of those special characters *^&@!");
                                message.show();
                            }
                        }
                        else {
                            message.setContentText("The passwords don't match");
                            message.show();


                        }

                    }
                    else {
                        message.setContentText("Please Enter a valid Email Address");
                        message.show();

                    }

                }
                else {
                    message.setContentText("Email Field cannot be empty");
                    message.show();
                }


            }
        });


    }



    public static Boolean emailChecker(String email){

        Pattern pattern = Pattern.compile("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$"); // This Regex was taken from https://www.baeldung.com/java-email-validation-regex
        Matcher matcher = pattern.matcher(email);
        return matcher.find();


    }
    public static boolean passwordChecker(String password){

        Pattern pattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[*^&@!]).{7,}$"); // this regex was taken from https://stackoverflow.com/a/19605207  - I only changed the length and special characters
        Matcher matcher = pattern.matcher(password);
        return matcher.find();



    }



    public static void main(String[] args) {

        launch();

    }



}