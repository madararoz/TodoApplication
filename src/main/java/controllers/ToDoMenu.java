package controllers;

import com.sun.corba.se.spi.ior.IdentifiableBase;

import javax.swing.*;
import java.util.Scanner;

public class ToDoMenu {

    TodoController todoController = new TodoController();


    public void start(){
      showOptions();
      handleUserChoice();


    }

    private void handleUserChoice() {
        String userChoice = JOptionPane.showInputDialog("Choose an option");
        switch(userChoice){
            case "1":
                todoController.addTodo();
                break;
            case "2":
                todoController.viewAllTodo();
                break;
            case "3":
                todoController.viewTodo();
                break;
            case "4":
                todoController.removeTodo();
                break;
            case "5":
                todoController.updateTodo();
                break;
            case "6":
                System.exit(0);
                break;
            default:
                System.out.println("Choose and option from the list");
                break;
        }
        start();
    }

    private void showOptions() {
        System.out.println("\n Welcome to Todo Application"
        + "\n 1. Add todo"
        + "\n 2. View Todo List"
        + "\n 3. View Todo "
        + "\n 4. Remove Todo"
        + "\n 5. Update Todo"
        + "\n 6. Exit"
        );
    }


}
