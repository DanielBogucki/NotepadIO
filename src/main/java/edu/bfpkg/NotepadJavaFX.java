/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bfpkg;

import edu.bfpkg.controllers.FormatPopUpController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class NotepadJavaFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/FXMLNotepad.fxml"));
        
        Scene scene = new Scene(root);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/icons/notepad.png")));
        stage.setTitle("Zaawansowany Notatnik");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
