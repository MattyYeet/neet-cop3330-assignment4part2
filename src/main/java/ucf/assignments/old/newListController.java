package ucf.assignments.old;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Matthew Neet
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class newListController {

    public static Stage newListStage;
    private Stage current = new Stage();

    public newListController(Stage current) {
        this.current = current;
        newListStage = this.current;
    }

    public newListController(){}

    @FXML
    private Button newListMade;

    @FXML
    void makeListNew(ActionEvent event) throws IOException {
        //adds list to list of lists
        //if null, does nothing
        current.close();
        //closes new list and opens ListBuilder
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ListBuilder.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.setTitle("To Do List");
        current.show();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new ListCommands(current));
    }

}

