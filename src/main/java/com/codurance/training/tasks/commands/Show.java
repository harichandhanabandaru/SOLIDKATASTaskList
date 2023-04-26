package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Show {

    private final PrintWriter out;
    private final Map<String, List<Task>> tasks ;
    public Show(PrintWriter out,Map<String, List<Task>> tasks)
    {
        this.tasks=tasks;
        this.out=out;
    }
    public void show() {

        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {

            out.println(project.getKey());
            for (Task task : project.getValue()) {

                out.printf("    [%c] %d: %s %s %n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription(),task.getCreatedAt());
                out.println();
            }
            out.println();
        }
    }
}
