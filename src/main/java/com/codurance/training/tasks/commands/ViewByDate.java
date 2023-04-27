package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.utils.DateFormat;

import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ViewByDate {
    private final PrintWriter out;
    private final Map<String, List<Task>> tasks ;
    public ViewByDate(PrintWriter out,Map<String, List<Task>> tasks)
    {
        this.tasks=tasks;
        this.out=out;
    }
    public void viewByDate(String commandLine) {

        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {

            out.println(project.getKey());
            for (Task task : project.getValue()) {

                    if (task.getCreatedAt().equals(commandLine)) {

                        out.printf("    [%c] %s: %s %s %n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription(), task.getCreatedAt());
                        out.println();
                    }

            }
            out.println();
        }
    }
}
