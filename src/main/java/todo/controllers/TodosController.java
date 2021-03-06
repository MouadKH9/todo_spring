package todo.controllers;

import todo.exceptions.TodoNotFound;
import todo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import todo.repos.TodoRepository;
import todo.responses.CreatedResponse;
import todo.responses.GenericResponse;
import todo.responses.Response;

import java.util.Optional;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
public class TodosController {
    @Autowired
    private TodoRepository todoRepo;

    @GetMapping("/todos")
    public @ResponseBody Iterable<Todo> getTodos(){
        return  todoRepo.findAll();
    }

    @GetMapping("todo/{id}")
    public @ResponseBody
    Todo getTodo(@PathVariable int id){
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
            todo.setDone(!todo.isDone());
            todoRepo.save(todo);
        });
        return new GenericResponse("success","Todo is done!");
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody Response deleteTodo(@PathVariable int id){
        todoRepo.deleteById(id);
        return  new GenericResponse("success","Todo deleted successfully!");
    }

    @PutMapping("/edit/{id}")
    public @ResponseBody
    GenericResponse editTodo(@PathVariable("id") int id,@RequestBody Todo old){
        todoRepo.findById(id).ifPresent(todo -> {
            todo.setText(old.getText());
            todoRepo.save(todo);
        });
        return new GenericResponse("success","Todo is done!");
    }

}
