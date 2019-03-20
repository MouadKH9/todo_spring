package com.mouadk.todo.repositories;

import com.mouadk.todo.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {
}
