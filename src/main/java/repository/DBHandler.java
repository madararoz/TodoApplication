package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler {

    String connectionUrl = "jdbc:mysql://localhost:3306/TodoApp";
    String user = "root";
    String pass = "root";

    private static Connection connection;

    public DBHandler(){
        try{
            connection = DriverManager.getConnection(connectionUrl,user,pass);

        } catch (SQLException ex){
            System.out.println("Unable to connect to database");
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;

    }

}
