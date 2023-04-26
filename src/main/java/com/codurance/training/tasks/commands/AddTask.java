package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.utils.DateFormat;

import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class AddTask {


    private final PrintWriter out;
    private final Map<String, List<Task>> tasks ;

    private  long lastId;

    public AddTask(PrintWriter out,Map<String, List<Task>> tasks,long lastId)
    {
        this.tasks=tasks;
        this.out=out;
        this.lastId=lastId;
    }

    public void addTask(String project, String description) {

        List<Task> projectTasks = tasks.get(project);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        try {
            projectTasks.add(new Task(lastId, description, false,
                    new DateFormat().dateFormat(DateFormat.formatDate(new Date()))));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
