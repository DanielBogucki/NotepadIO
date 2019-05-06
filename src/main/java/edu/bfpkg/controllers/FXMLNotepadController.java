package edu.bfpkg.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class FXMLNotepadController {

    @FXML
    private BorderPane borderPane;

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

    Stage stage;

    private File file;


    @FXML
    void close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void find(ActionEvent event) {

    }

    @FXML
    void font(ActionEvent event) {

    }

    @FXML
    void info(ActionEvent event) {

    }

    @FXML
    void open(ActionEvent event) {
        if (stage == null) setStage();
        FileChooser fileChooser = new FileChooser();
        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("pliki TXT (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            textArea.setText(readFile());
            stage.setTitle("Zaawansowany notatnik" + " (" + file.getName() + ")");
        }
    }

    @FXML
    void redo(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {
        if (stage == null) setStage();
        if (file == null) {
            saveToFile(event);
        } else {
            saveTextToFile(textArea.getText());
            stage.setTitle("Zaawansowany notatnik" + " (" + file.getName() + ")");
        }

    }

    @FXML
    void saveToFile(ActionEvent event) {
        if (stage == null) setStage();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("pliki TXT (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            saveTextToFile(textArea.getText());
            stage.setTitle("Zaawansowany notatnik" + " (" + file.getName() + ")");
        }
    }

    @FXML
    void undo(ActionEvent event) {

    }

    private void setStage() {
        stage = (Stage) borderPane.getScene().getWindow();
    }

    private void saveTextToFile(String text) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(text);
            writer.close();

            Alert confirm = new Alert(Alert.AlertType.INFORMATION);
            confirm.setTitle("Saving OK");
            confirm.setHeaderText("Plik " + file.getName() + " poprawnie zapisany");
            confirm.show();

        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Saving error");
            alert.setHeaderText("Błąd podczas zapisu do pliku");
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
            alert.setHeaderText("Błąd odczytu pliku");
            alert.setContentText(file.getAbsolutePath());
            alert.show();
        }
        return result;
    }
}
