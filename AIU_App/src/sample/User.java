package sample;

public class User {
    public static String st_username;
    public static String st_password;
    public static String st_first_name;
    public static String st_last_name;
    public static String st_email;
    public static String st_course;

    public User(String username, String password, String first_name, String last_name, String email, String course) {
        st_username = username;
        st_password = password;
        st_first_name = first_name;
        st_last_name = last_name;
        st_email = email;
        st_course = course;
    }

}