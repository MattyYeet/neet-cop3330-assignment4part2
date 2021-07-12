package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Matthew Neet
 */

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.time.LocalDate;

//In the final version, I decided not to use this, but left it here anyways

public class NewEditItemController {
    public TextArea itemDesc;
    public DatePicker dueDate;

    public void saveItem() throws IOException {

        //itemDesc.clear();

        ViewChanger.stage.close();
        ViewChanger.newWindow(View.MAIN);
    }
}
