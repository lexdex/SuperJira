package com.company;

import com.company.Interfaces.StateMove;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

public class Task implements StateMove {

    private UUID Id;
    private String taskName;
    private String task;
    private String date;
    private String assignedTo;
    private boolean tested;
    private State currentState;

    public Task() {
    }

    public Task(String TaskName, String task, String assignedTo) {
        this.Id = UUID.randomUUID();
        this.taskName = TaskName;
        this.assignedTo = assignedTo;
        this.task = task;
        this.currentState = State.OPEN;
        this.date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public boolean isTested() {
        return tested;
    }

    public void setTested(boolean tested) {
        this.tested = tested;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID id) {
        Id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "task{" +
                "Id=" + Id +
                ", taskName='" + taskName + '\'' +
                ", task='" + task + '\'' +
                ", date=" + date +
                ", tested=" + tested +
                ", assignedTo='" + assignedTo + '\'' +
                ", currentState=" + currentState +
                '}';
    }
}
