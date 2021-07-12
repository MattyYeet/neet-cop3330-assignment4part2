package ucf.assignments;

public enum View {
    START("StartGUI.fxml"),
    MAIN("ListMainGUI.fxml"),
    NEW_EDIT_ITEM("NewEditItemGUI.fxml"),
    DELETE_ITEM("DeleteItemGUI.fxml"),
    CONFIRM_DELETE("confirmDeleteGUI.fxml"),
    HELP("HelpGUI.fxml");

    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }
}
