package com.company;

import com.company.Interfaces.Command;

import java.util.*;

public class Menu {

    private Map<String, String> menu;
    //private Map<String, Command> methods;
    private Command command;
    private TaskManager manager;
    private Scanner input;

    public Menu() {
        input = new Scanner(System.in);
        menu = new LinkedHashMap<>();
        //methods = new HashMap<>();
        command = new TaskViewer();
        manager = TaskManager.getTaskManager();
        initMenu();
    }


    private void initMenu() {
        menu.put("1", "AddTask");
        menu.put("2", "RemoveTask");
        menu.put("3", "ShowAllActiveTasks");
        menu.put("4", "ChangeTaskStatus");
        menu.put("5", "ChangeTaskAssigned");
        menu.put("6", "ChangeTaskTested");
        //Error! ?? void return type
        /*methods.put("1", new TaskManager().addTask());
        methods.put("2", new TaskManager().removeTask());
        methods.put("3", new TaskManager().showAllTasks());
        methods.put("4", new TaskManager().changeTaskState());
        methods.put("5", new TaskManager().changeAssignedPerson());
        methods.put("6", new TaskManager().changeTestedStatus());*/
    }

    public void show() {
        int choice;

        do {
            System.out.println("\n\t\t ~~MENU~~");
            menu.forEach((k, v) -> System.out.println(k + "-" + v));
            System.out.println("0-Quit");
            System.out.print("Select here: ");
            choice = Integer.parseInt(input.nextLine());

            manager = command.execute(choice, manager);
        } while (choice != 0);
    }


}
