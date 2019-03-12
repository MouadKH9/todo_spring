package com.mouadk.todo.todo;

import exceptions.TodoNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import responses.CreatedResponse;
import responses.GenericResponse;
import responses.Response;

import java.util.Optional;

@RestController
public class TodosController {
    @Autowired
    private TodoRepository todoRepo;

    @GetMapping("/todos")
    public @ResponseBody Iterable<Todo> getTodos(){
        return  todoRepo.findAll();
    }

    @GetMapping("todo/{id}")
    public @ResponseBody Todo getTodo(@PathVariable int id){
        Optional<Todo> opt = todoRepo.findById(id);
        if(!opt.isPresent()) throw new TodoNotFound(String.format("Couldn't find the user %d",id));
        return opt.get();
    }

    @PostMapping("/add")
    public @ResponseBody
    Response addTodo(@RequestBody Todo todo){
        todoRepo.save(todo);
        return new CreatedResponse(todo.getId(),"Todo created successfully!");
    }

    @PutMapping("/done/{id}")
    public @ResponseBody
    GenericResponse todoDone(@PathVariable("id") int id){
        todoRepo.findById(id).ifPresent(todo -> {
            todo.setDone(true);
            todoRepo.save(todo);
        });
        return new GenericResponse("success","Todo is done!");
    }
}
