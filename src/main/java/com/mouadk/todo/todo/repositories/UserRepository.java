package com.mouadk.todo.todo.repositories;

import com.mouadk.todo.todo.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
