package com.company;

import com.company.Interfaces.Command;

import java.util.*;

public class Menu {

    private Map<String, String> menu;
    private Command command;
    private TaskManager manager;
    private Scanner input;

    public Menu() {
        input = new Scanner(System.in);
        menu = new LinkedHashMap<>();
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
