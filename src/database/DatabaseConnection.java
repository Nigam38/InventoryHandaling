package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static DatabaseConnection instance = null;
    private static Connection connection = null;

    private DatabaseConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/" + login.DB_NAME + "?serverTimezone=UTC",
                        login.DB_USER, login.DB_PASSWORD);
                System.out.println("Successfully connected.");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static DatabaseConnection getInstance() {
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
