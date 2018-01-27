package com.ballistic.barco.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by Nabeel on 1/26/2018.
 */
@Component
public class TodoEventListener {

    @Async
    @EventListener(condition = "#todoEvent.isAdmin()")
    public void handleUserEvent(TodoEvent todoEvent) {
        System.out.println(todoEvent.getTodo().getUsername());
    }
}
