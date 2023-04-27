package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.utils.DateFormat;

import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ViewByDeadLine {
    private final PrintWriter out;
    private final Map<String, List<Task>> tasks ;
    public ViewByDeadLine(PrintWriter out,Map<String, List<Task>> tasks)
    {
        this.tasks=tasks;
        this.out=out;
    }
    public void viewByDeadLine(String commandLine) {

        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {

//            out.println(project.getKey());
            for (Task task : project.getValue()) {
                    if(task.getDeadLine() != null) {

                        if (task.getDeadLine().equals(commandLine)) {

                            out.printf("    [%c] %s: %s %s %s %n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription(), task.getCreatedAt(), task.getDeadLine());
                            out.println();
                        }
                    }
            }
            out.println();
        }
    }
}

