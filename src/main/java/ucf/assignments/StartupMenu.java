package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Matthew Neet
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;
import java.util.Objects;

public class StartupMenu {

    @FXML
    private Button make_new_startup;

    @FXML
    private Button view_all;

    @FXML
    private Button delete_startup;

    public static Stage StartupStage;
    private Stage current = new Stage();

    public StartupMenu(Stage current) {
        this.current = current;
        StartupStage = this.current;
    }
    public StartupMenu(){}

    @FXML
    void Delete_Item_List(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DeleteItem_or_List.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.show();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new DeleteItemList(current));
        StartupStage.close();
    }

    @FXML
    void Make_New_Item_List(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewItem_or_List.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.show();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new NewItemList(current));
        StartupStage.close();
    }

    @FXML
    void View_All_Lists(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ListBuilder.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.setTitle("To Do List");
        current.show();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new NewItemList(current));
        StartupStage.close();
    }

}
