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

public class whichItem {

    public static Stage whichItemStage;
    private Stage current = new Stage();

    public whichItem(Stage current) {
        this.current = current;
        whichItemStage = this.current;
    }
    public whichItem(){}

    @FXML
    private Button which_Item_delete;

    @FXML
    void removeOneItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("confirmDelete.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.show();
        //whichItemStage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new whichItem(current));
    }

}
