package com.ballistic.barco.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nabeel on 1/26/2018.
 */
@RestController
public class TodoEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping(value = "/user/{name}/admin/{role}", method = RequestMethod.GET)
    public void hitme(@PathVariable("name") String name, @PathVariable("role") Boolean isAdmin) {
        Todo todo = new Todo();
        todo.setUsername(name);
        todo.setAdmin(isAdmin);
        todo.setStatus("ACTIVE");

        TodoEvent todoEvent = new TodoEvent(this,todo);
        applicationEventPublisher.publishEvent(todoEvent);

    }
}
