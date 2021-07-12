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

public class DeleteItemList {

    public static Stage DeleteItemListStage;
    private Stage current = new Stage();

    public DeleteItemList(Stage current) {
        this.current = current;
        DeleteItemListStage = this.current;
    }
    public DeleteItemList(){}

    @FXML
    private Button delete_Item;

    @FXML
    private Button delete_List;

    @FXML
    void DeleteItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("whichItem.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.show();
        DeleteItemListStage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new whichItem(current));
        //deletes from list of items
    }

    @FXML
    void DeleteList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("whichList.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.show();
        DeleteItemListStage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new NewItemList(current));
        //deletes from list of lists
    }

}
