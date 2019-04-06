package notepadjavafx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

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

    }

    @FXML
    void redo(ActionEvent event) {

    }

    @FXML
    void save(ActionEvent event) {

    }

    @FXML
    void undo(ActionEvent event) {

    }

}
