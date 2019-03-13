package com.mouadk.todo.todo.controllers;

import com.mouadk.todo.todo.entities.User;
import com.mouadk.todo.todo.exceptions.TodoNotFound;
import com.mouadk.todo.todo.repositories.UserRepository;
import com.mouadk.todo.todo.responses.GenericResponse;
import com.mouadk.todo.todo.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsersController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/user/{id}")
    public @ResponseBody User getUser(@PathVariable int id){
        Optional<User> user = userRepo.findById(id);
        if(!user.isPresent()) throw new TodoNotFound("User Not Found");
        return user.get();
    }

    @GetMapping("/users")
    public @ResponseBody Iterable<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping("users/add")
    public  @ResponseBody Response addUser(@RequestBody User user){
        userRepo.save(user);
        return new GenericResponse("success","User created successfully!");
    }

    @PutMapping("user/{id}")
    public @ResponseBody Response editUser(@PathVariable int id, @RequestBody User user){
        User old = userRepo.findById(id).get();
        old.setUsername(user.getUsername());
        userRepo.save(old);
        return new GenericResponse("success","User updated successfully");
    }

    @DeleteMapping("user/{id}")
    public @ResponseBody Response deleteUser(@PathVariable int id){
        userRepo.deleteById(id);
        return new GenericResponse("success","User deleted successfully");
    }

}
