package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

public class TaskManager {
private int taskCounter=0;
private LinkedHashMap<String, Task> tasklist;

    public TaskManager() {
        taskCounter=0;
        tasklist = new LinkedHashMap<>();
    }


    String readString() {
        String readString = "";
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            readString = sc.next();
        }
        sc.close();
        return readString;
    }

    public Task addTask() {
        String taskName = "";
        Task currentTask = new Task();

        System.out.println("Enter Task name ");
        currentTask.TaskName = readString();
        taskName = currentTask.TaskName;


        System.out.println("Enter Task");
        currentTask.Task = readString();

        System.out.println("Enter team member  you wish to assign task");
        currentTask.AssignedTo = readString();

        currentTask.Id = UUID.randomUUID();
        currentTask.date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        currentTask.tested = false;
        currentTask.currentState = State.Open;
        tasklist.put(taskName, currentTask);
        taskCounter++;
        return currentTask;
    }

    public void  removeTask() {
        String toRemove = "";
        Task t;
        System.out.println("Enter task you wish to remove");
        toRemove = readString();
        if (tasklist.containsKey(toRemove)) {
                    tasklist.remove(toRemove);
            taskCounter--;

        } else {
            System.out.println("There is no such value in the task list");
        }

    }


    public void changeAssignedPerson() {
        String change = "";
        System.out.println("Enter task you wish to change person assigned");
        change = readString();
        if (tasklist.containsKey(change)) {
            String changeperson = "";
            System.out.println("Enter new person you wish to assign task");
            changeperson = readString();
            if (changeperson != null) {
                Task t = tasklist.get(change);
                t.AssignedTo = changeperson;
            } else {
                System.out.println("Assigned person cannot be empty");
            }
        } else {
            System.out.println("There is no such value in the task list");
        }
    }

   public  void changeTestedStatus() {
        String change = "";
        System.out.println("Enter task you wish to change tested status");
        change = readString();
        if (tasklist.containsKey(change)) {
            boolean isTested = false;
            System.out.println("Enter \"true\" if tested or \"false\" value if not tested");
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                isTested = sc.nextBoolean();
            }
            sc.close();
            Task t = tasklist.get(change);
            t.tested = isTested;
        } else {
            System.out.println("There is no such value in the task list");
        }
    }


  public   void showllAllTasks() {
        int active=0;
        System.out.println("There are currently "+taskCounter+" total tasks");
        for (var key : tasklist.keySet()) {
            var values = tasklist.get(key);
            if (values.currentState!=State.Closed)
            {System.out.println(values);
            active++;}
        }
        System.out.println("There are currently " +active+ " active tasks total");
    }

 public  void changeTaskState() {
        var toChange = readString();
        if (tasklist.containsKey(toChange)) {
            var task = tasklist.get(toChange);
            System.out.println("Task is now in state");
            System.out.println(task.currentState);
            System.out.println("State can be changed to ");


        } else {
            System.out.println("There is no such value in the task list");
        }
    }


    public void changeTaskState(Task task) {
        if (task.currentState.equals(State.Open)) {
            System.out.println("type \"inprogress\" to change status to inprogress");
            if (readString().equals("inprogress")) {
                task.MoveInProgress(task);
            } else {
                System.out.println("You can change status only to InProgress");
            }
        }
        if (task.currentState.equals(State.InProgress)) {
            System.out.println("type \"resolved\" to change status to resolved  or  \"opened\" to change status to reopened");
            String result = readString();
            if (result.equals("resolved")) {
                task.MoveResolved(task);
            }
            if (result.equals("opened")) {
                task.MoveOpen(task);
            } else {
                System.out.println("You can change status only to Resolved or Opened");
            }
        }
        if (task.currentState.equals(State.Resolved)) {
            System.out.println("type \"closed \" to change status to closed  or  \"reopened\" to change status to reopened");
            String result = readString();
            if (result.equals("closed")) {
                task.MoveClosed(task);
            }
            if (result.equals("reopend")) {
                task.MoveReopen(task);
            } else {
                System.out.println("You can change status only to ReOpened or Closed");
            }
        }


        if (task.currentState.equals(State.ReOpened)) {
            System.out.println("type \"inprogress\" to change status to inprogress");
            if (readString().equals("inprogress")) {
                task.MoveInProgress(task);
            } else {
                System.out.println("You can change status only to InProgress");
            }
        }


        if (task.currentState.equals(State.Closed)) {
            System.out.println("type \"opened\" to change status to opened");
            if (readString().toLowerCase().equals("opened")) {
                task.MoveOpen(task);
            } else {
                System.out.println("You can change status only to Open");
            }
        }


    }


}




