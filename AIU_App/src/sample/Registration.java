package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class Registration {

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
    private Label passwordNotMatching;

    @FXML
    private PasswordField Password;

    @FXML
    private PasswordField Password2;

    @FXML
    private Button btnSignUp;

    ObservableList<String> courses = FXCollections.observableArrayList("COM21-A", "COM21-B", "MAT21", "COM20-A", "COM20-B", "MAT20", "COM19-A", "COM19-B", "MAT19", "COM18", "MAT18");

    public void initialize(){
        Course.setItems(courses);
    }
    @FXML
    void signUp(ActionEvent event) throws Exception{
        if (FirstName.getText().isEmpty() || LastName.getText().isEmpty() || Email.getText().isEmpty() || Username.getText().isEmpty() || Course.getValue().isEmpty() || Password.getText().isEmpty() || Password2.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill ALL fields given");
            alert.showAndWait();

        } else {
            if (Password.getText().equals(Password2.getText())){
                User user = new User(Username.getText(), Password.getText(), FirstName.getText(), LastName.getText(), Email.getText(), Course.getValue());
                DataBase.Registering(FirstName.getText(), LastName.getText(), Email.getText(), Username.getText(), Course.getValue(), Password.getText());

                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                passwordNotMatching.setOpacity(1);
            }
        }
    }

}
