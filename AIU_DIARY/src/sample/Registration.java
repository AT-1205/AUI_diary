package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class Registration {

    ObservableList<String> courses = FXCollections.observableArrayList("COM21-A", "COM21-B", "MAT21-A", "MAT21-B", "COM20-A", "COM20-B", "MAT20-A", "MAT20-B", "COM19-A", "COM19-B", "MAT19-A", "MAT19-B", "COM18-A", "COM18-B", "MAT18-A", "MAT18-B");

    @FXML
    private TextField FirstName;

    @FXML
    private TextField LastName;

    @FXML
    private TextField Email;

    @FXML
    private TextField Username;

    @FXML
    private ComboBox<String> Course;

    @FXML
    private PasswordField Password;

    @FXML
    private PasswordField Password2;

    @FXML
    private Button btnSignUp;

    @FXML
    private void initialize(){
        Course.setItems(courses);
    }

    @FXML
    void signUp(ActionEvent event) {
        if (Password.getText().equals(Password2.getText())){
            DB_connect.writeToDatabase(FirstName.getText(), LastName.getText(), Email.getText(), Username.getText(), Course.getValue(), Password.getText());
        } else {
            System.out.println("Passwords are not similar!");
        }
    }
}


