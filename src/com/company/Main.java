package com.company;

import com.company.Controllers.InterfaceController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.beans.EventHandler;
import java.io.IOException;

public class Main extends Application {
    private static Stage winStage = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Resources/interface.fxml"));
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        switchScene();
    }

    public void switchScene(){
        winStage = new Stage();
        winStage.setTitle("You won!");
        winStage.setAlwaysOnTop(true);
        winStage.setResizable(false);
        winStage.initModality(Modality.APPLICATION_MODAL);
    }

    public static Stage getStage() {
        return winStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
