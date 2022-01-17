package sample;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    public static void Registering(String first_name, String last_name, String email, String username, String course, String pass_word){
        String url = "jdbc:postgresql://localhost:5432/oop_project";
        String user = "postgres";
        String password = "alatoo20";

        String query = "INSERT INTO users_list(first_name, last_name, email, username, course, pass_word) VALUES(?, ?, ?, ?, ?, ?);";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, first_name);
            pst.setString(2, last_name);
            pst.setString(3, email);
            pst.setString(4, username);
            pst.setString(5, course);
            pst.setString(6, pass_word);
            pst.executeUpdate();

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DataBase.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }


    public static void SigningIn(String username, String pass_word){
        String url = "jdbc:postgresql://localhost:5432/oop_project";
        String user = "postgres";
        String password = "alatoo20";

        String query = "SELECT * FROM users_list WHERE username = ? AND pass_word = ? ;";
        ResultSet resultSet;

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, username);
            pst.setString(2, pass_word);
            resultSet = pst.executeQuery();
            while (resultSet.next()){
                User user1 = new User(
                        resultSet.getString("username"),
                        resultSet.getString("pass_word"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"),
                        resultSet.getString("course")
                );
            }
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(DataBase.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static void AddingTask(String deadline, String course, String task){
        String url = "jdbc:postgresql://localhost:5432/oop_project";
        String user = "postgres";
        String password = "alatoo20";

        String query = "INSERT INTO tasks(deadline, course, task, username) VALUES(?, ?, ?, ?);";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, deadline);
            pst.setString(2, course);
            pst.setString(3, task);
            pst.setString(4, User.st_username);
            pst.executeUpdate();
            System.out.println("task created.");
        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DataBase.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static void DisplayInTableView(ObservableList list, TableView tableView){
        ResultSet rs = null;
        String url = "jdbc:postgresql://localhost:5432/oop_project";
        String user = "postgres";
        String password = "alatoo20";

        String query = "SELECT * FROM tasks WHERE username = ?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, User.st_username);
            rs = pst.executeQuery();
            while (rs.next()){list.add(new Tasks(
                    rs.getString("deadline"),
                    rs.getString("course"),
                    rs.getString("task")
            ));
            tableView.setItems(list);
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DataBase.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
