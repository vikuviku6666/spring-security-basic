package com.vin.learn_spring_security.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoResource
{
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public List<Todo> todoList = new ArrayList<>();

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos()
    {
        return todoList;
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosByUsername(@PathVariable String username)
    {
        return todoList.getFirst();
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo)
    {
        todoList.add(todo);
        logger.info("Create {} for {}", todo, username);
    }

}

