package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Matthew Neet
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ucf.assignments.old.StartupMenu;

import java.io.IOException;
import java.util.Objects;

public class ViewChanger {

    public static Stage stage = new Stage();
    private static Scene scene;
    public static Stage newStage = new Stage();
    private static Scene newScene;

    public static void changeTo(View view) throws IOException {
        if(scene == null){
            System.out.println("Nothing here");
        }
        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewChanger.class.getResource(view.getFileName())));
        scene.setRoot(root);
        stage.setScene(scene);
        stage.setTitle("To Do List");
        stage.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setController(new StartupMenu(stage));
    }

    public static void setScene(Scene scene){
        ViewChanger.scene = scene;
    }

    public static void newWindow(View view) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(ViewChanger.class.getResource(view.getFileName())));
        newScene = new Scene(root);
        if(scene == null){
            System.out.println("Nothing here");
        }
        newScene.setRoot(root);
        newStage.setScene(newScene);
        newStage.setTitle("To Do List");
        newStage.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setController(new StartupMenu(stage));
    }
}
