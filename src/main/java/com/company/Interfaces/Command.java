package com.company.Interfaces;

import com.company.TaskManager;

public interface Command {
  public  default TaskManager execute(int command,TaskManager taskManager){
        if (command==1){
            taskManager.addTask();
        }
        if (command==2){
            taskManager.removeTask();
        }
        if (command==3)
        {
            taskManager.changeTaskState();
        }

        if (command ==4)
        {
            taskManager.showllAllTasks();
        }
        if (command==5){
            taskManager.changeAssignedPerson();
        }
        if (command==6){
            taskManager.changeTestedStatus();
        }
        return taskManager;
    }
}
