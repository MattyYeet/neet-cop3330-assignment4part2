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

public class whichList {

    public static Stage whichListStage;
    private Stage current = new Stage();

    public whichList(Stage current) {
        this.current = current;
        whichListStage = this.current;
    }
    public whichList(){}

    @FXML
    private Button deleteListdone;

    @FXML
    void removeOneList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("confirmDelete.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.show();
        //whichListStage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new whichItem(current));
    }

}
