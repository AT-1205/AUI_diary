package com.project.aui_diary;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ChangeScene {

    public Stage stage;
    public Scene scene;

    public void newStage(ActionEvent event, String currentStage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(currentStage)));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
