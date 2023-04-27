package com.codurance.training.tasks.commands;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.utils.DateFormat;


import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class DeadLine {
    private final Map<String, List<Task>> tasks ;

    public DeadLine(Map<String, List<Task>> tasks){
        this.tasks=tasks;
    }

    public void deadLine(String commandLine)  {
        String[] subcommandRest = commandLine.split(" ", 2);
            for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
                for (Task task : project.getValue()) {
                    if (task.getId().equals(subcommandRest[0])) {
                        try {
                            task.setDeadLine(new DateFormat().dateFormat(subcommandRest[1]));
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }

                        return;
                    }
                }
            }

    }

}
