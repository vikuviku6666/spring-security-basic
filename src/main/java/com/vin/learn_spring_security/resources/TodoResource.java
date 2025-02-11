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
    public List<Todo>   todoList2 = List.of(new Todo("king_vinay", "Learn Spring Security"), new Todo("king_vinay", "Learn DSA"));

    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos()
    {
        if(todoList.isEmpty()){
            return todoList2;
        }else{
            return todoList;
        }
    }

    @GetMapping("/users/{username}/todos")
    public Todo retrieveTodosByUsername(@PathVariable String username)
    {
        if(todoList.isEmpty()){
            return todoList2.getFirst();
        }else{
            return todoList.getFirst();
        }
    }

    @PostMapping("/users/{username}/todos")
    public void createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo)
    {
        todoList.add(todo);
        logger.info("Create {} for {}", todo, username);
    }

}

