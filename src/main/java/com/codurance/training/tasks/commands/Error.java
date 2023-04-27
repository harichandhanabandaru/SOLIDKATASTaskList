package com.codurance.training.tasks.commands;

import java.io.PrintWriter;

public class Error {

    private final PrintWriter out;

    public Error(PrintWriter writer)
    {
        this.out = writer;
    }
    public void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }
}
