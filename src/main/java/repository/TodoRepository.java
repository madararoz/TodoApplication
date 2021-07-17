package repository;

import entity.Todo;
import types.Status;

import javax.lang.model.type.ArrayType;
import java.sql.*;
import java.util.ArrayList;

public class TodoRepository {

    private DBHandler dbHandler = new DBHandler();
    public void addTodoToDB(Todo todo) throws SQLException {
        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO todos (description, dueDate, dueTime, status)" + "VALUES(?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, todo.getDescription());
        preparedStatement.setDate(2, (Date) todo.getDueDate());
        preparedStatement.setTime(3, todo.getDueTime());
        preparedStatement.setString(4, todo.getStatus().toString());


        preparedStatement.execute();



    }

    public ArrayList<Todo> getAllTodoFromDB() throws SQLException {
        ArrayList<Todo> todoItems = new ArrayList<>();
        String query = "SELECT * FROM todos";
        PreparedStatement preparedStatement = dbHandler.getConnection().prepareStatement(query);
        ResultSet result = preparedStatement.executeQuery();


        while(result.next()) {
            todoItems.add(new Todo(
                    result.getInt("id"),
                    result.getString("description"),
                    result.getDate("dueDate"),
                    result.getTime("dueTime"),
                    Status.valueOf(result.getString("status"))

            ));
        }
        return todoItems;
    }
}
