package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Matthew Neet
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;
import javafx.util.converter.LocalDateStringConverter;

import java.io.IOException;
import java.time.LocalDate;

public class Items {
    private String description;
    private LocalDate dateDue;
    private CheckBox done;

    public Items(){
        this.description = "";
        this.dateDue = LocalDate.now();
        this.done = new CheckBox();
    }

    public Items(String description, LocalDate dateDue, CheckBox done){
        this.description = description;
        this.dateDue = dateDue;
        this.done = new CheckBox();
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setDateDue(LocalDate dateDue) {
        this.dateDue = dateDue;
    }

    public void setDone(CheckBox done) {
        this.done = done;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDateDue() {
        return dateDue;
    }
    public CheckBox getDone(){
        return done;
    }

    @Override
    public String toString() {
        return "Items{" +
                "description='" + description + '\'' +
                ", dateDue=" + dateDue +
                ", done=" + done +
                '}';
    }
}

