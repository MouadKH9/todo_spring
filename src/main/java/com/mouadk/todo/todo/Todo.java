package com.mouadk.todo.todo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private int id;
    private String text;
    private boolean done;

    Todo(){}

    public Todo(int id, String text, boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
