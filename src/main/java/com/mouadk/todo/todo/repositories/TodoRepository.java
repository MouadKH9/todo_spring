package com.mouadk.todo.todo.repositories;

import com.mouadk.todo.todo.entities.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo,Integer> {

}
