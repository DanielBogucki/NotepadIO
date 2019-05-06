package edu.bfpkg.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class FormatPopUpController {

    @FXML
    private ListView<String> listViewFonts;

    @FXML
    private TextField txtFontSize;

    private ObservableList<String> observableListFonts;

    private FXMLNotepadController fxmlNotepadController = new FXMLNotepadController();

    @FXML
    public void initialize() {
        observableListFonts = FXCollections.observableArrayList(Font.getFamilies());
        listViewFonts.setItems(observableListFonts);

        String defaultFont = Font.getDefault().getFamily();
        int defaultFontIndex = observableListFonts.indexOf(defaultFont);

        listViewFonts.getSelectionModel().select(defaultFontIndex);
        listViewFonts.getFocusModel().focus(defaultFontIndex);
        listViewFonts.scrollTo(defaultFontIndex);
    }

    @FXML
    private Button btnSave;


    @FXML
    void onSave(ActionEvent event) {
        new Thread(() -> fxmlNotepadController.setStyle(Double.parseDouble(txtFontSize.getText()))).start();
    }

}
