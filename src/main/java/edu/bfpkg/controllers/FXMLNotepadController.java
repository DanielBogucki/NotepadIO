package edu.bfpkg.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class FXMLNotepadController {

    @FXML
    private MenuItem btnFind;

    @FXML
    private MenuItem btnInfo;

    @FXML
    private Button btnOpen;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUndo;

    @FXML
    private Button btnRedo;

    @FXML
    private TextArea textArea;

    private File file;

    @FXML
    void initialize(){

    }

    @FXML
    void close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void find(ActionEvent event) {

    }

    void setStyle(double fontSize){
        textArea.setStyle("-fx-font-size:" + fontSize +";");
    }

    @FXML
    void font(ActionEvent event) throws IOException {
        Parent dialogPane = FXMLLoader.load(getClass().getResource("/fxml/FormatPopUp.fxml"));
        Stage dialog;
        Scene scene = new Scene(dialogPane);
        dialog = new Stage();
        dialog.setScene(scene);
        dialog.showAndWait();
    }

    @FXML
    void info(ActionEvent event) {

    }

    @FXML
    void open(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        file = fileChooser.showOpenDialog(null);

        if (file != null) {
            textArea.setText(readFile());
        }
    }

    @FXML
    void redo(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        file = fileChooser.showSaveDialog(null);

        if (file != null) {
            saveTextToFile(textArea.getText());
        }
    }

    @FXML
    void undo(ActionEvent event) {

    }

    private void saveTextToFile(String text) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(text);
            writer.close();

            Alert confirm = new Alert(Alert.AlertType.INFORMATION);
            confirm.setTitle("Saving OK");
            confirm.setHeaderText("File " + file.getName() + " properly saved");
            confirm.show();

        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Saving error");
            alert.setHeaderText("There was an error during saving to file");
            alert.setContentText(file.getAbsolutePath());
            alert.show();
        }
    }

    private String readFile() {
        Scanner sc = null;
        String result = "";
        try {
            sc = new Scanner(file);
            sc.useDelimiter("\\Z");
            result = sc.next();
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Reading error");
            alert.setHeaderText("There was an error during reading from file");
            alert.setContentText(file.getAbsolutePath());
            alert.show();
        }
        return result;
    }
}
