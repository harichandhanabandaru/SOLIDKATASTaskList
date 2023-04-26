package com.codurance.training.tasks;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Task {
    private final long id;
    private final String description;
    private boolean done;

    private Date deadLine;

    private Date createdAt;
    public Task(long id, String description, boolean done,Date createdAt) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.createdAt=createdAt;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }



    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDeadLine() {
        if(deadLine!= null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            return formatter.format(deadLine);
        }
        return null;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine=deadLine;

    }

    public String getCreatedAt() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(createdAt);
    }

    public void setCreatedAt(Date deadLine) {
        this.createdAt=createdAt;

    }

}
