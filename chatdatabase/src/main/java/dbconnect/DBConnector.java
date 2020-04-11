package dbconnect;

import core.User;

import java.sql.*;

public class DBConnector {


    public static Connection dbConnector() throws ClassNotFoundException, SQLException {


        String host = "us-cdbr-iron-east-01.cleardb.net";
        int port = 3306;
        String database = "heroku_1e57249a9e2bdf7";
        String  username = "b03ed90f473d6f";
        String password = "6edaf317";


        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://"+host+":" + port +"/"+database,username,password);

        return con;

        }

        public static User login(String login, String password) {
            Connection dbconn = null;
            try {
                dbconn = dbConnector();
                String query = "SELECT * FROM heroku_1e57249a9e2bdf7.user where login = '" + login + "' and password = '" + password + "';";

                Statement stmt  = dbconn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next()) {
                    User user = new User(rs.getInt("UserID"), rs.getString("Login"), rs.getString("Password"));
                    return user;
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

        public   static void registration(String login, String password){

            try {
                Connection dbconn = dbConnector();

                String query = "INSERT INTO user(Login, Password) VALUES(?,?)";
                PreparedStatement ps = dbconn.prepareStatement(query);
                ps.setString(1, login);
                ps.setString(2,password);
                ps.executeQuery();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}
