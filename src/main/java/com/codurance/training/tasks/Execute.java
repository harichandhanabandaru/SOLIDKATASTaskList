package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.codurance.training.tasks.commands.Show;
import com.codurance.training.tasks.commands.Check;
import com.codurance.training.tasks.commands.Help;
import com.codurance.training.tasks.commands.Error;
import com.codurance.training.tasks.commands.AddProject;
import com.codurance.training.tasks.commands.AddTask;
import com.codurance.training.tasks.commands.DeadLine;
import com.codurance.training.tasks.commands.TodayDeadline;
import com.codurance.training.tasks.commands.ViewByDate;
import com.codurance.training.tasks.commands.ViewByDeadLine;
import com.codurance.training.tasks.commands.ViewByProject;
import com.codurance.training.tasks.interfaces.Execution;

public class Execute implements Execution {

   private static final Map<String, List<Task>> tasks = new LinkedHashMap<>();

    private static long lastId=0;


    private final BufferedReader in;
    private final PrintWriter out;
    public Execute(BufferedReader reader, PrintWriter writer){
        this.in = reader;
        this.out = writer;
    }

    private  long nextId() {
        return ++lastId;
    }

    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            new AddProject(tasks).addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            new AddTask(out,tasks,nextId()).addTask(projectTask[0], projectTask[1]);
        }


    }



    @Override
    public void execution(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];

        switch (command) {
            case "show":
                new Show(out,tasks).show();
                break;
            case "add":
                add(commandRest[1]);
                break;
            case "check":
                new Check(out,tasks).check(commandRest[1]);
                break;
            case "uncheck":
                new Check(out,tasks).uncheck(commandRest[1]);
                break;
            case "deadline":
                new DeadLine(tasks).deadLine(commandRest[1]);
                break;
            case "today":
                new TodayDeadline(out,tasks).todayDeadline();
                break;
            case "viewByDate":
                new ViewByDate(out,tasks).viewByDate(commandRest[1]);
                break;
            case "viewByDeadLine":
                new ViewByDeadLine(out,tasks).viewByDeadLine(commandRest[1]);
                break;
            case "viewByProject":
                new ViewByProject(out,tasks).viewByProject(commandRest[1]);
                break;
            case "help":
                new Help(out).help();
                break;
            default:
                new Error(out).error(command);
                break;
        }
    }
}
