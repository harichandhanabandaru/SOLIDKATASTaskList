package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.codurance.training.tasks.Run;


public final class TaskList  {
//    private static final String QUIT = "quit";
//
//    private final BufferedReader in;
//    private final PrintWriter out;

//    public TaskList(BufferedReader reader, PrintWriter writer) {
//        this.in = reader;
//        this.out = writer;
//    }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
//        new TaskList(in, out);
        new Run(in, out).run();
    }

}
