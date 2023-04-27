package com.codurance.training.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


public class Run {

    private final BufferedReader in;
    private final PrintWriter out;

    private static final String QUIT = "quit";



    public Run(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }
    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String command;
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (command.equals(QUIT)) {
                break;
            }
            new Execute(in,out).execution(command);
        }
    }
}
