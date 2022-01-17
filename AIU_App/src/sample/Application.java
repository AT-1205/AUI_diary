package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;


public class Application {

    @FXML
    private Label studentsName;

    @FXML
    private Label studentsId;

    @FXML
    private Label studentsCourse;

    @FXML
    private Label date;

    @FXML
    private TableView<Tasks> tableTasks;

    @FXML
    private TableColumn<Tasks, String> deadline;

    @FXML
    private TableColumn<Tasks, String> course;

    @FXML
    private TableColumn<Tasks, String> task;

    @FXML
    private DatePicker fieldDeadline;

    @FXML
    private ComboBox<String> fieldCourse;

    @FXML
    private TextField fieldTask;

    @FXML
    private Button btnAddTask;

    @FXML
    private Button btnSave;

    ObservableList<String> COM = FXCollections.observableArrayList("Ecology", "Turkish Language",
            "Algebra and Geometry", "Engineering Computer Graphics", "Programming Language",
            "Russian Language", "Kyrgyz Language", "Physical training", "Object-Oriented Programming",
            "Web Technologies", "Database System", "Electronics", "Discrete Mathematics",
            "Mobile App Development", "Information Security", "Statistics", "Software engineering",
            "Computer Networks");

    ObservableList<String> MAT = FXCollections.observableArrayList("Discrete Mathematics",
            "Differential equations", "Abstract Algebra", "Philosophy", "Calculus", "Physics",
            "Optimization Methods", "Operating Systems", "Equations of mathematical physics",
            "Kyrgyz Language", "Physical training", "Number Theory", "Manastaanuu",
            "Computer Graphics", "Programming Language");

    ObservableList<Tasks> tasksList = FXCollections.observableArrayList();

    long millis = System.currentTimeMillis();
    java.sql.Date currentDate = new java.sql.Date(millis);
    public void initialize(){
        date.setText(currentDate.toString());
        studentsName.setText(User.st_first_name + " " + User.st_last_name);
        studentsId.setText(User.st_username);
        studentsCourse.setText(User.st_course);


        if (User.st_course.equals("COM21-A") || User.st_course.equals("COM21-B") || User.st_course.equals("COM20-A") ||
                User.st_course.equals("COM20-B") || User.st_course.equals("COM19-A") || User.st_course.equals("COM19-B") ||
                User.st_course.equals("COM18")){
            fieldCourse.setItems(COM);
        } else {
            fieldCourse.setItems(MAT);
        }
        SettingTable();
    }

    @FXML
    void onAddTask(ActionEvent event) {
        DataBase.AddingTask(fieldDeadline.getValue().toString(), fieldCourse.getValue(), fieldTask.getText());
    }

    @FXML
    void onSave(ActionEvent event) {
        SettingTable();
    }

    public void SettingTable(){
        deadline.setCellValueFactory(new PropertyValueFactory<>("deadline"));
        course.setCellValueFactory(new PropertyValueFactory<>("course"));
        task.setCellValueFactory(new PropertyValueFactory<>("task"));

        DataBase.DisplayInTableView(tasksList, tableTasks);
    }

}
