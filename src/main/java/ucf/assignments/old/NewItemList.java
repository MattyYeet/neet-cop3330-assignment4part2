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

public class NewItemList {

    public static Stage NewItemListStage;
    private Stage current = new Stage();

    public NewItemList(Stage current) {
        this.current = current;
        NewItemListStage = this.current;
    }

    public NewItemList(){}

    @FXML
    private Button new_Item;

    @FXML
    private Button new_List;

    @FXML
    void NewItem(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("new_editItem.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.show();
        NewItemListStage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new whichItem(current));
    }

    @FXML
    void NewList(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("newList.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.show();
        NewItemListStage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new whichItem(current));
    }

}

