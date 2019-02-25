package com.company;

import com.company.Interfaces.Command;

public class TaskViewer implements Command {
    public TaskManager execute(int command,TaskManager taskManager){
        if (command==1) {
            taskManager.addTask();
        }
        if (command==2) {
            taskManager.removeTask();
        }
        if (command==3) {
            taskManager.showAllTasks();
        }

        if (command ==4) {
            taskManager.changeTaskState();
        }

        if (command==5) {
            taskManager.changeAssignedPerson();
        }

        if (command==6) {
            taskManager.changeTestedStatus();
        }

        return taskManager;
    }
}
