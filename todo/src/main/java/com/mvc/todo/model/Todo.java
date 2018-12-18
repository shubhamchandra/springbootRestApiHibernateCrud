package com.mvc.todo.model;

import javax.persistence.*;

@Entity
@Table(name="todo")
public class Todo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="description")
    private String description;

    @Column(name="isdone")
    private boolean isDone;

    public Todo() {}

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
