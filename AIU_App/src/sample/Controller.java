package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Controller {

    @FXML
    public TextField fieldUsername;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    public Label incorrectPwdUnm;

    @FXML
    private Button btnSignIn;

    @FXML
    private Hyperlink register;

    private Stage stage;
    private Scene scene;

    @FXML
    void signIn(ActionEvent event) throws Exception{
        try {
            DataBase.SigningIn(fieldUsername.getText(), fieldPassword.getText());

            Parent root = FXMLLoader.load(getClass().getResource("Application.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            incorrectPwdUnm.setOpacity(1);
        }
    }

    @FXML
    void toRegister(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
