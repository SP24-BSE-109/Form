package com.form.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class App extends Application {

    private ArrayList<Map<String, String>> userData = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        GridPane grid = new GridPane();

        grid.setPadding(new Insets(20));
        grid.setVgap(15);
        grid.setHgap(15);

        Label titleLabel = new Label("Registration Form");


        titleLabel.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 24));


        grid.add(titleLabel, 0, 0, 2, 1);
        FadeInAnimate(titleLabel);

        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        grid.add(nameLabel, 0, 1);
        grid.add(nameField, 1, 1);
        FadeInAnimate(nameLabel);
        FadeInAnimate(nameField);
        Label dobLabel = new Label("Date of Birth:");
        DatePicker dobPicker = new DatePicker();
        grid.add(dobLabel, 0, 2);
        grid.add(dobPicker, 1, 2);
        FadeInAnimate(dobLabel);
        FadeInAnimate(dobPicker);
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        grid.add(usernameLabel, 0, 3);
        grid.add(usernameField, 1, 3);
        FadeInAnimate(usernameLabel);
        FadeInAnimate(usernameField);
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        grid.add(passwordLabel, 0, 4);
        grid.add(passwordField, 1, 4);
        FadeInAnimate(passwordLabel);
        FadeInAnimate(passwordField);
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        grid.add(emailLabel, 0, 5);
        grid.add(emailField, 1, 5);
        FadeInAnimate(emailLabel);
        FadeInAnimate(emailField);
        Button submitButton = new Button("Submit");

        submitButton.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD,14));

        grid.add(submitButton, 1, 6);
        FadeInAnimate(submitButton);
        Label successLabel = new Label();

        successLabel.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD,14));
        grid.add(successLabel, 0, 7, 2, 1);

        submitButton.setOnAction(e -> {
            Map<String, String> user = new HashMap<>();
            user.put("Name", nameField.getText());
            user.put("Date of Birth", dobPicker.getValue() != null ? dobPicker.getValue().toString() : "");
            user.put("Username", usernameField.getText());
            user.put("Password", passwordField.getText());
            user.put("Email", emailField.getText());

            userData.add(user);

            nameField.clear();
            dobPicker.setValue(null);
            usernameField.clear();
            passwordField.clear();
            emailField.clear();

            successLabel.setText("User data saved successfully!");
            FadeOutAnimate(successLabel);
            System.out.println("User data saved: " + user);
        });


        Image image = new Image("file:person.png");

        ImageView contactImageView = new ImageView(image);
        contactImageView.setFitWidth(200);
        contactImageView.setPreserveRatio(true);
        contactImageView.setSmooth(true);
        FadeInAnimate(contactImageView);


        HBox hbox = new HBox(20, grid, contactImageView);
        hbox.setPadding(new Insets(20));
        hbox.setAlignment(Pos.CENTER_LEFT);

        Scene scene = new Scene(hbox, 700, 400);
        stage.setTitle("User Form");
        stage.setScene(scene);

        stage.setResizable(false);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


    public void FadeOutAnimate(Node node){
        FadeTransition fade = new FadeTransition(Duration.seconds(2), node);
        fade.setFromValue(1.0);
        fade.setToValue(0.0);
        fade.play();
    }
    public void FadeInAnimate(Node node){
        FadeTransition fade = new FadeTransition(Duration.seconds(2), node);
        fade.setFromValue(0.0);
        fade.setToValue(1);
        fade.play();
    }
}