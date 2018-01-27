package com.ballistic.barco.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by Nabeel on 1/26/2018.
 */
public class TodoEvent extends ApplicationEvent {

    private Todo todo;
    private final Boolean isAdmin;

    public TodoEvent(Object source, Todo todo) {
        super(source);
        this.todo = todo;
        this.isAdmin = todo.getAdmin();
    }

    public Todo getTodo() { return todo; }
    public Boolean isAdmin() { return isAdmin; }

}
