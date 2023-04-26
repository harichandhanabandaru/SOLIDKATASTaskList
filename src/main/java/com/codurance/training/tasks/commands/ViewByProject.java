package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.utils.DateFormat;

import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class ViewByProject {

    private final PrintWriter out;
    private final Map<String, List<Task>> tasks ;
    public ViewByProject(PrintWriter out,Map<String, List<Task>> tasks)
    {
        this.tasks=tasks;
        this.out=out;
    }
    public void viewByProject(String commandLine) {

        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {

            out.println(project.getKey());
            if (project.getKey().equals(commandLine)) {
                for (Task task : project.getValue()) {
                    out.printf("    [%c] %d: %s %s %s %n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription(), task.getCreatedAt(), task.getDeadLine());
                    out.println();

                }
                out.println();
            }
        }
    }
}


