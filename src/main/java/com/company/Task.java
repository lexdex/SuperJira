package com.company;

import com.company.Interfaces.StateMove;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Task implements StateMove {

    UUID Id;
    String TaskName;
    String Task;
    String date;
    String AssignedTo;
    public boolean tested;
    public State currentState;

    public Task() {
    }


    public Task(String TaskName, String task, String assignedTo) {
        this.Id = UUID.randomUUID();
        this.TaskName = TaskName;
        this.AssignedTo = assignedTo;
        this.Task = task;
        this.currentState = State.Open;
        this.date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    @Override
    public String toString() {
        return "Task{" +
                "Id=" + Id +
                ", TaskName='" + TaskName + '\'' +
                ", Task='" + Task + '\'' +
                ", date=" + date +
                ", tested=" + tested +
                ", AssignedTo='" + AssignedTo + '\'' +
                ", currentState=" + currentState +
                '}';
    }

    public boolean isTested() {
        return tested;
    }

    public void setTested(boolean tested) {
        this.tested = tested;
    }


}
