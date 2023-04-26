package com.codurance.training.tasks.commands;

import java.io.PrintWriter;

public class Help {

    private final PrintWriter out;

    public Help(PrintWriter writer)
    {
        this.out = writer;
    }

    public void help() {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println();
    }
}
