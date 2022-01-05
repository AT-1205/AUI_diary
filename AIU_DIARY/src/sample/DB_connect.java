package sample;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB_connect {
    public static void writeToDatabase(String FirstName, String LastName, String Email, String Username, String Course, String Password) {

        String url = "jdbc:postgresql://localhost:5432/oop_project";
        String user = "postgres";
        String password = "alatoo20";

        String first_name = FirstName;
        String last_name = LastName;
        String email = Email;
        String username = Username;
        String course = Course;
        String pass_word = Password;


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
            System.out.println("Successfully created.");

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DB_connect.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
