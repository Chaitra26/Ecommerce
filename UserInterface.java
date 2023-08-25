package com.example.ecommerce;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class UserInterface {
    GridPane loginPage;
    HBox headerBar;
    public BorderPane createContent(){
        BorderPane root = new BorderPane();
        root.setPrefSize(880,600);
        //root.getChildren().add(loginPage); //add node as children to pane
        root.setCenter(loginPage);
        root.setTop(headerBar);
        return root;
    }


    public UserInterface(){

        createLoginPage();
        createHeaderBar();
    }

    private void createLoginPage() {
        Text userNameText = new Text("User Name");
        Text passwordText = new Text("Password");
        TextField userName = new TextField();
        userName.setPromptText("Type your user name here");
        PasswordField password = new PasswordField();
        password.setPromptText("Type your password here");
        Label messageLabel = new Label("Hi");

        Button loginButton = new Button("Login");
        loginPage = new GridPane();

        //loginPage.setStyle(" -fx-background-color: violet;");
        loginPage.setAlignment(Pos.CENTER);
        loginPage.setHgap(10);
        loginPage.setVgap(10);
        loginPage.add(userNameText, 0, 0);
        loginPage.add(userName, 1, 0);
        loginPage.add(passwordText, 0, 1);
        loginPage.add(password, 1, 1);
        loginPage.add(messageLabel, 0, 2);
        loginPage.add(loginButton, 1, 2);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String name = userName.getText();
                messageLabel.setText(name);
            }
        });
    }
        private void createHeaderBar() {
        TextField searchBar = new TextField();
        searchBar.setPromptText("Search here");
        searchBar.setPrefWidth(280);
        Button searchButton = new Button("Search");

        headerBar = new HBox();
       // headerBar.setStyle(" -fx-background-color: violet;");
        headerBar.setPadding(new Insets(10));
        headerBar.setSpacing(10);
        headerBar.setAlignment(Pos.CENTER);
        headerBar.getChildren().addAll(searchBar,searchButton);
        }
    }

