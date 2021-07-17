package entity;

import types.Status;

import java.sql.Time;
import java.util.Date;

public class  Todo {
    int id;
    String description;
    Date dueDate;
    Time  dueTime;
    Status status;


    public Todo(int id, String description, Date dueDate, Time dueTime, Status status) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
        this.status = status;
    }

    public Todo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Time getDueTime() {
        return dueTime;
    }

    public void setDueTime(Time dueTime) {
        this.dueTime = dueTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id +
              " \t" + status +
              " \t"+ dueDate +
              " \t"+ dueTime +
              " \t" + description;
    }
}
