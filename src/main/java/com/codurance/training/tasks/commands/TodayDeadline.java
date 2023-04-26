package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.utils.DateFormat;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TodayDeadline {

    private final PrintWriter out;
    private final Map<String, List<Task>> tasks ;
    public TodayDeadline(PrintWriter out, Map<String, List<Task>> tasks)
    {
        this.tasks=tasks;
        this.out=out;
    }
    public void todayDeadline() {

        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {

//            out.println(project.getKey());
            for (Task task : project.getValue()) {
                    if(task.getDeadLine() != null) {
                        if (task.getDeadLine().equals(new DateFormat().formatDate(new Date()))) {

                            out.printf("    [%c] %d: %s %s %n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription(), task.getDeadLine());
                            out.println();
                        }
                    }
            }
            out.println();
        }
    }
}
