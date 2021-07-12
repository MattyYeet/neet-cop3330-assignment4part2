package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Matthew Neet
 */

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

//In the final version, I decided not to use this, but left it here anyways

public class DeleteItemController {
    public TextField searchDelete;
    public Button DeleteYes;
    public Button nevermind;

    public void remove() throws IOException {
        ViewChanger.stage.close();
        ViewChanger.changeTo(View.CONFIRM_DELETE);
    }
    public void cancel() throws IOException {
        ViewChanger.stage.close();
        ViewChanger.newWindow(View.MAIN);
    }
}
