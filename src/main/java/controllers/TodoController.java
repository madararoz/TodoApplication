package controllers;

import entity.Todo;
import repository.TodoRepository;
import types.Status;

import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class TodoController {
    TodoRepository todoRepository = new TodoRepository();

    public void addTodo() {
        Todo todo = collectTodoInfo();
        try {
            todoRepository.addTodoToDB(todo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public void removeTodo(){
        int todoId = Integer.parseInt(getUserInput("id of task to delete"));

        try {
            todoRepository.deleteTask(todoId);
            System.out.println("Task removed succesfully");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }


    public void updateTodo(){
        int todoId = Integer.parseInt(getUserInput("id of task to update"));
        int userChoice = JOptionPane.showConfirmDialog(null, "Is task complete?");
        System.out.println(userChoice);
        if(userChoice == 2) return;
       Status newStatus = userChoice == 0 ? Status.COMPLETED : Status.PENDING;
        try {
            todoRepository.updateTask(todoId, newStatus);
            System.out.println("Todo status changed");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void viewTodo(){
        Todo todo = null;

        try {
            int todoId = Integer.parseInt(getUserInput("id of task to view"));
            todo = todoRepository.getTodoFromDB(todoId);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(todo);
    }

//    private Todo findTaskByDescription(String todoDescription, ArrayList<Todo> todoList) {
//            for(Todo todo: todoList ){
//                if(todo.getDescription().equalsIgnoreCase(todoDescription) ) {
//                    System.out.println(todo.getId() +"\t" + todo.getStatus() + "\t" + todo.getDueDate() + "\t " + todo.getDueTime() + "\t" + todo.getDescription());
//                    return todo;
//                }
//            } return null;
//    }





    public void viewAllTodo(){
        ArrayList<Todo> todoList = new ArrayList<>();
        try {
            todoList = todoRepository.getAllTodoFromDB();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        displayTodoList(todoList);
    }




    private Todo collectTodoInfo() {
        Todo todo = new Todo();
        todo.setDescription(getUserInput("Description"));
        todo.setDueDate(Date.valueOf(getUserInput("Due Date (2021-07-26)")));
        todo.setDueTime(Time.valueOf(getUserInput("Due Time (21:40)")+ ":00"));
        todo.setStatus(Status.PENDING);

        return todo;
    }

    private String getUserInput(String info){
        return JOptionPane.showInputDialog("Enter " + info);
    }

    private void displayTodoList(ArrayList<Todo> todolist){
        System.out.println("id \tstatus \tdue date & time \tdescription");
        todolist.forEach(System.out::println);
    }



}
