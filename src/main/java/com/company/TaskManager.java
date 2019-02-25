package com.company;

import java.text.SimpleDateFormat;
import java.util.*;

public class TaskManager {
    private static TaskManager manager;

    private int taskCounter;
    private LinkedHashMap<String, Task> taskList;

    public TaskManager() {
        taskList = new LinkedHashMap<>();
    }

    String readString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public Task addTask() {
        String taskName = "";
        Task currentTask = new Task();

        System.out.print("Enter task name: ");
        currentTask.setTaskName(readString());
        taskName = currentTask.getTaskName();

        System.out.print("Enter task: ");
        currentTask.setTask(readString());

        System.out.print("Enter team member you wish to assign task: ");
        currentTask.setAssignedTo(readString());

        currentTask.setId(UUID.randomUUID());
        currentTask.setDate(new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()));
        currentTask.setTested(false);
        currentTask.setCurrentState(State.OPEN);
        taskList.put(taskName, currentTask);
        taskCounter++;

        return currentTask;
    }

    public void  removeTask() {
        String toRemove = "";

        System.out.println("Enter task you wish to remove");
        toRemove = readString();
        if (taskList.containsKey(toRemove)) {
            taskList.remove(toRemove);
            taskCounter--;
        } else {
            System.out.println("There is no such value in the task list");
        }
    }

    public void changeAssignedPerson() {
        String change = "";
        System.out.println("Enter task you wish to change person assigned");
        change = readString();
        if (taskList.containsKey(change)) {
            String changeperson = "";
            System.out.println("Enter new person you wish to assign task");
            changeperson = readString();
            if (changeperson != null) {
                Task t = taskList.get(change);
                t.setAssignedTo(changeperson);
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
        if (taskList.containsKey(change)) {
            boolean isTested = false;
            System.out.println("Enter \"true\" if tested or \"false\" value if not tested");
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                isTested = sc.nextBoolean();
            }
            sc.close();
            Task t = taskList.get(change);
            t.setTested(isTested);
        } else {
            System.out.println("There is no such value in the task list");
        }
    }


    public void showAllTasks() {
        int active=0;
        System.out.println("There are currently " + taskCounter + " total tasks");
        for (var key : taskList.keySet()) {
            var values = taskList.get(key);
            if (values.getCurrentState() != State.CLOSED)
            {System.out.println(values);
            active++;}
        }
        System.out.println("There are currently " + active + " active tasks total");
    }

    public void changeTaskState() {
        var toChange = readString();
        if (taskList.containsKey(toChange)) {
            var task = taskList.get(toChange);
            System.out.println("task is now in state");
            System.out.println(task.getCurrentState());
            System.out.println("State can be changed to ");
        } else {
            System.out.println("There is no such value in the task list");
        }
    }

    public void changeTaskState(Task task) {
        if (task.getCurrentState().equals(State.OPEN)) {
            System.out.println("type \"inprogress\" to change status to inprogress");
            if (readString().equals("inprogress")) {
                task.moveInProgress(task);
            } else {
                System.out.println("You can change status only to IN_PROGRESS");
            }
        }

        if (task.getCurrentState().equals(State.IN_PROGRESS)) {
            System.out.println("type \"resolved\" to change status to resolved  or  \"opened\" to change status to reopened");
            String result = readString();
            if (result.equals("resolved")) {
                task.moveResolved(task);
            }
            if (result.equals("opened")) {
                task.moveOpen(task);
            } else {
                System.out.println("You can change status only to RESOLVED or Opened");
            }
        }

        if (task.getCurrentState().equals(State.RESOLVED)) {
            System.out.println("type \"closed \" to change status to closed  or  \"reopened\" to change status to reopened");
            String result = readString();
            if (result.equals("closed")) {
                task.moveClosed(task);
            }
            if (result.equals("reopend")) {
                task.moveReopen(task);
            } else {
                System.out.println("You can change status only to REOPENED or CLOSED");
            }
        }

        if (task.getCurrentState().equals(State.REOPENED)) {
            System.out.println("type \"inprogress\" to change status to inprogress");
            if (readString().equals("inprogress")) {
                task.moveInProgress(task);
            } else {
                System.out.println("You can change status only to IN_PROGRESS");
            }
        }

        if (task.getCurrentState().equals(State.CLOSED)) {
            System.out.println("type \"opened\" to change status to opened");
            if (readString().toLowerCase().equals("opened")) {
                task.moveOpen(task);
            } else {
                System.out.println("You can change status only to OPEN");
            }
        }
    }

    public static TaskManager getTaskManager() {
        if (manager == null) {
            return new TaskManager();
        }
        return manager;
    }
}