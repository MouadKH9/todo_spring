package com.mouadk.todo.repositories;

import com.mouadk.todo.entities.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo,Integer> {

}
