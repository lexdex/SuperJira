package com.company;

import com.company.Interfaces.Command;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Map<String, String> menu;
    private Map<String, Command> methods;
    private Scanner input;

    public Menu() {
        input = new Scanner(System.in);
        menu = new LinkedHashMap<>();
        methods = new HashMap<>();
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
        methods.put("1", new TaskManager().addTask());
        methods.put("2", new TaskManager().removeTask());
        methods.put("3", new TaskManager().showllAllTasks());
        methods.put("4", new TaskManager().changeTaskState());
        methods.put("5", new TaskManager().changeAssignedPerson());
        methods.put("6", new TaskManager().changeTestedStatus());

    }

    public void show() {

        String userInput;
        do {
            System.out.println("\n\t\t ~~MENU~~");
            menu.forEach((k, v) -> System.out.println(k + "-" + v));
            System.out.println("Q-Quit");
            userInput = input.next();
            try {
                methods.get(userInput).
            } catch (NullPointerException e) {
            }
        } while (!userInput.equalsIgnoreCase("Q"));
    }


}
