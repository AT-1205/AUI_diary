package com.project.aui_diary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller extends ChangeScene {

    @FXML
    private ImageView exitBtn;



    public void goToRegistr(ActionEvent event) throws IOException {
        newStage(event,"Register.fxml");
    }

    public void exit() {
        Stage stage = (Stage) exitBtn.getScene().getWindow();
        stage.close();
    }
}