package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Matthew Neet
 */

import javafx.scene.control.Button;

import java.io.IOException;

//In the final version, I decided not to use this, but left it here anyways

public class confirmDeleteController {
    public Button yesDelete;
    public Button noDelete;

    public void confirmDelete() throws IOException {
        ViewChanger.newStage.close();
        ViewChanger.changeTo(View.MAIN);
    }
    public void dontDelete() throws IOException {
        ViewChanger.newStage.close();
        ViewChanger.changeTo(View.MAIN);
    }
}
