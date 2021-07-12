package ucf.assignments.old;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class New_EditItem_Menu {

    public static Stage NewEditItemStage;
    private Stage current = new Stage();

    public New_EditItem_Menu(Stage current) {
        this.current = current;
        NewEditItemStage = this.current;
    }
    public New_EditItem_Menu(){}

    @FXML
    private Button neweditItemdone;

    @FXML
    void New_EditDone(ActionEvent event) {
        //adds a new item to the list
        current.close();
    }
}
