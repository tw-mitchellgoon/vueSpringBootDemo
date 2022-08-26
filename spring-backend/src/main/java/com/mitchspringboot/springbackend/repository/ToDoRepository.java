package com.mitchspringboot.springbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mitchspringboot.springbackend.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM todolist ")
    List<ToDo> ToDoList();
}
