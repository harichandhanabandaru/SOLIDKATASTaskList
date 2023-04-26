package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddProject {


    private final Map<String, List<Task>> tasks ;
    public AddProject(Map<String, List<Task>> tasks)
    {
        this.tasks=tasks;
    }
    public void addProject(String name) {

        tasks.put(name, new ArrayList<Task>());


    }

}
