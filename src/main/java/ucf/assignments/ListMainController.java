package ucf.assignments;

/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Matthew Neet
 */

//As I went through this assignment, I know i turned it in late, and I screwed myself over by giving myself an extra day to do nothing.
//Another thing I realized is that it was a whole lot easier to have the buttons that add, remove, and edit items to the list on the main screen
//so that's why this controller is huge, but that was a part of cutting out the fat for me, unless im just dumb and didnt realize a better way.
//One thing that did make this assignment easier was the Items.java class where its basically an object class, so i can set up the items better
//Whoever grades this, im sorry if its messy, but please give me honest feedback, I would appreciate it more than i can express, thank you

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

public class ListMainController implements Initializable {
    public Button addButton;
    public Button editButton;
    public Button removeButton;
    public TextArea itemDesc;
    public DatePicker dueDate;
    @FXML private TextField filterSearch;
    @FXML private TableView<Items> tableView;
    @FXML private TableColumn<Items, String> DescriptionCol;
    @FXML private TableColumn<Items, LocalDate> DateCol;
    @FXML private TableColumn<Items, CheckBox> doneColumn;
    @FXML private MenuBar fileMenu;

    static CheckBox check = new CheckBox();

    public ListMainController(){
    }

    public static ObservableList<Items> getPeople(){
        //adding dummy items to the list so i know it works
        ObservableList<Items> person = FXCollections.observableArrayList();

        person.add(new Items("game time", LocalDate.of(2021, Month.JANUARY, 25), check));
        person.add(new Items("make new friends", LocalDate.of(2021, Month.MAY, 25), check));
        person.add(new Items("sleep time", LocalDate.of(2021, Month.DECEMBER, 25), check));
        return person;
    }

    ObservableList<Items> observableItemList = FXCollections.observableArrayList();

    private void filterItemList(String oldValue, String newValue) {
        //First attempt at making a filter
        ObservableList<Items> filteredList = FXCollections.observableArrayList();
        if(filterSearch == null || (newValue.length() < oldValue.length()) || newValue == null){
            tableView.setItems(observableItemList);
        }
        else{
            newValue = newValue.toUpperCase();
            for(Items item : tableView.getItems()){
                String filterDesc = item.getDescription();
                if(filterDesc.toUpperCase().contains(newValue) ||check.isSelected()){
                    filteredList.add(item);
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Part of making the first filter
        //FilteredList<Items> checkList = new FilteredList<>();
        //tableView.setItems(checkList);

        /*filterSearch.textProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue observable, String oldValue, String newValue) {
                filterItemList((String) oldValue, (String) newValue);
            }
        });*/

        //initializing the table and columns
        try {


            DescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
            DateCol.setCellValueFactory(new PropertyValueFactory<>("dateDue"));
            doneColumn.setCellValueFactory(new PropertyValueFactory<>("done"));

            tableView.setItems(getPeople());

            tableView.getColumns().addAll(DescriptionCol, DateCol, doneColumn);

            //My failed attempts at trying to make the cells editable, please let me know what I did wrong
            tableView.setEditable(true);
            //DescriptionCol.setCellValueFactory(TextFieldTableCell.forTableColumn());
            //DateCol.setCellValueFactory(TextFieldTableCell.forTableColumn());
        }
        catch (Exception e){
            System.out.println("fuuuuuuuuuuuuck");
        }
    }


    //These first two methods were part of trying to make the cells editable
    public void changeDescriptionColumn(Event e){
        //Items itemSelected = tableView.getSelectionModel().getSelectedItem();
        //itemSelected.setDescription(edittedCell.getNewValue().toString());
        /*TableColumn.CellEditEvent<Items, String> cellEditEvent;
        cellEditEvent = (TableColumn.CellEditEvent<Items, String>) e;
        Items item = cellEditEvent.getRowValue();
        item.setDescription(cellEditEvent.getNewValue());*/
    }
    public void changeDateColumn(TableColumn.CellEditEvent edittedCell){
        Items itemSelected = tableView.getSelectionModel().getSelectedItem();
        itemSelected.setDateDue(LocalDate.now());
    }

    //Adding an item
    public void newItem() {
        Items item = new Items();
        item.setDescription(itemDesc.getText());
        item.setDateDue(dueDate.getValue());
        //wont add the item if something isnt there
        if(item.getDescription().equals("")){
            System.out.println("description is empty");

        }
        else if(item.getDateDue() == null){
            System.out.println("date is empty");
        }
        else{
            item.setDone(check);
            tableView.getItems().add(item);
            itemDesc.clear();
            dueDate.setValue(null);
        }
    }

    //This was the original plan for editing the items, I couldnt figure out how to
    //take what was already there and throw it back in the fields
    public void editItem(){
        Items item = tableView.getSelectionModel().getSelectedItem();
        item.setDescription(itemDesc.getText());
        item.setDateDue(dueDate.getValue());
        item.setDone(check);
        tableView.getItems().add(item);
        itemDesc.clear();
        dueDate.setValue(null);
    }

    //Removes an item
    public void deleteItem(){
        ObservableList<Items> itemSelected, allItems;
        allItems = tableView.getItems();
        itemSelected = tableView.getSelectionModel().getSelectedItems();
        itemSelected.forEach(allItems::remove);
    }

    //Pulls up the Help Menu
    public void onHelp() throws IOException {
        ViewChanger.newWindow(View.HELP);
    }

    //Loading a list
    public void loadList(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        /*Collection<Items> list = Files.readAllLines(new File("").toPath())
                .stream().map(line -> {String[] details = line.split(",");{LocalDate[] dates = line.split(",")}
                    Items item = new Items();
                    item.setDescription(details[0]);
                    item.setDateDue(dates[1]);
                    return item;
        });*/
    }

    //Saving a list
    public void saveList(ObservableList<Items> observableItemList, File file){
        try{
            BufferedWriter outWrite = new BufferedWriter(new FileWriter(file));

            for(Items item : observableItemList){
                outWrite.write(item.toString());
                outWrite.newLine();
            }
            System.out.println(observableItemList);
            outWrite.close();
        } catch (IOException e){
            System.out.println("Sorry, an error happened");
        }
    }
    public void handleSave(ActionEvent event){
        Stage thirdStage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Items to");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        if(observableItemList.isEmpty()){
            thirdStage.initOwner(this.fileMenu.getScene().getWindow());
            Alert noItems = new Alert(Alert.AlertType.ERROR, "NO ITEMS", ButtonType.OK);
            noItems.setContentText("There's nothing to save!");
            noItems.initModality(Modality.APPLICATION_MODAL);
            noItems.initOwner(this.fileMenu.getScene().getWindow());
            noItems.showAndWait();
            if(noItems.getResult() == ButtonType.OK){
                noItems.close();
            }
        }
        else{
            File file = fileChooser.showSaveDialog(thirdStage);
            if(file != null){
                saveList(tableView.getItems(), file);
            }
        }
    }
}
