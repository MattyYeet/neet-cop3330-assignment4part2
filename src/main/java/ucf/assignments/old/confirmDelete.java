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

public class confirmDelete {

    public static Stage confirmDeleteStage;
    private Stage current = new Stage();

    public confirmDelete(Stage current) {
        this.current = current;
        confirmDeleteStage = this.current;
    }
    public confirmDelete(){}

    @FXML
    private Button yes;

    @FXML
    private Button no;

    @FXML
    void deleteNo(ActionEvent event) {
        //nothing happens
        current.close();
    }

    @FXML
    void deleteYes(ActionEvent event) throws IOException {
        //removes thing
        current.close();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ListBuilder.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.setTitle("To Do List");
        current.show();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new ListCommands(current));
    }

}
