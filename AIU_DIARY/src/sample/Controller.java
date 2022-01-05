package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField fieldUsername;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private Button btnSignIn;

    @FXML
    private Hyperlink register;

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void signIn(ActionEvent event) throws IOException{
        System.out.println(fieldUsername.getText());
        System.out.println(fieldPassword.getText());


        Parent root = FXMLLoader.load(getClass().getResource("application.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    public void toRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
