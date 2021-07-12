package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Matthew Neet
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ucf.assignments.old.StartupMenu;
import java.io.IOException;
import java.util.Objects;

public class NewToDoListApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("StartGUI.fxml")));
            Scene scene = new Scene(root);

            ViewChanger.setScene(scene);
            ViewChanger.changeTo(View.START);

            /*primaryStage.setScene(scene);
            primaryStage.setTitle("To Do List");
            primaryStage.show();

            FXMLLoader loader = new FXMLLoader();
            loader.setController(new StartupMenu(primaryStage));*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
