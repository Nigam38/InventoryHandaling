package database;

import java.sql.*;

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
            try {
                createTable(DBTables.TABLE_CATEGORY, DBTables.CREATE_TABLE_CATEGORY, connection);
                createTable(DBTables.TABLE_LOGIN, DBTables.CREATE_TABLE_LOGIN, connection);
                createTable(DBTables.TABLE_ITEM, DBTables.CREATE_TABLE_ITEM, connection);

            }catch (Exception e) {
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

    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {
        Statement createTables;
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables("npateldb",null, tableName,null);
        if(resultSet.next()) {
            System.out.println(tableName + " Table already exists!");
        }else  {
            createTables = connection.createStatement();
            createTables.execute(tableQuery);
            System.out.println("The " + tableName + " table has been created");

        }
    }

    public static Connection getConnection() {
        return connection;
    }
}





















