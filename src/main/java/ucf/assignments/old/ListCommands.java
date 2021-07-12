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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ListCommands {

    public static Stage ListCommandsStage;
    private Stage current = new Stage();

    public ListCommands(Stage current) {
        this.current = current;
        ListCommandsStage = this.current;
    }
    public ListCommands(){}

    @FXML
    private Button new_List_Main;

    @FXML
    private Button new_item_Main;

    @FXML
    private Button edit;

    @FXML
    private Button remove;

    @FXML
    private CheckBox ListCheckbox;

    @FXML
    private CheckBox ItemCheckbox;

    @FXML
    private CheckBox CompCheckbox;

    @FXML
    private TableView<?> TableList;

    @FXML
    private TableColumn<?, ?> TableNameLists;

    @FXML
    private TableColumn<?, ?> TableCheck;

    @FXML
    void CompletedCheckOn(ActionEvent event) {
        //adds completion to the filter
    }

    @FXML
    void EditClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("new_editItem.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.show();
        //ListCommandsStage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new New_EditItem_Menu(current));
    }

    @FXML
    void ItemCheckOn(ActionEvent event) {
        //adds item to the filter
    }

    @FXML
    void ListCheckOn(ActionEvent event) {
        //adds list to the filter
    }

    @FXML
    void New_ItemClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("new_editItem.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.show();
        //ListCommandsStage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new New_EditItem_Menu(current));
    }

    @FXML
    void New_ListClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("newList.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.show();
        //ListCommandsStage.close();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new newListController(current));
    }

    @FXML
    void RemoveClicked(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DeleteItem_or_List.fxml")));

        Scene scene = new Scene(root);

        current.setScene(scene);
        current.show();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new DeleteItemList(current));
        //continues from there
    }

}
