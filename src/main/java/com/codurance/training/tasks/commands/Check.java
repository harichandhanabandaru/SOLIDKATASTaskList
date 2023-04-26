package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.Task;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Check {


    private final PrintWriter out;
    private final Map<String, List<Task>> tasks ;

    public Check(PrintWriter writer,Map<String, List<Task>> tasks){
        this.out = writer;
        this.tasks=tasks;
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId() == id) {
                    task.setDone(done);
                    return;
                }
            }
        }
        out.printf("Could not find a task with an ID of %d.", id);
        out.println();
    }


    public void check(String idString) {
        setDone(idString, true);
    }

    public void uncheck(String idString) {
        setDone(idString, false);
    }
}
