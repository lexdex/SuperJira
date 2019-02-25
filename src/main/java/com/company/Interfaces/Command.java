package com.company.Interfaces;

import com.company.TaskManager;

public interface Command {
    TaskManager execute(int command, TaskManager manager);
}
