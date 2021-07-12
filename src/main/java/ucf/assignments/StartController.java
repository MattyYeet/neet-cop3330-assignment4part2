package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Matthew Neet
 */

import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;

import java.io.IOException;

public class StartController {
    public Button Load;

    public void viewAll() throws IOException {
        ViewChanger.stage.close();
        ViewChanger.changeTo(View.MAIN);
    }
    public void loadList(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
    }
}
