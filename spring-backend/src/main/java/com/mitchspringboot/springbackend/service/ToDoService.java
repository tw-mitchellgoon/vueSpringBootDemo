package com.mitchspringboot.springbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitchspringboot.springbackend.model.ToDo;
import com.mitchspringboot.springbackend.repository.ToDoRepository;

@Service
public class ToDoService {
    @Autowired
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    // public ToDo addToDo() {

    // }

    public List<ToDo> getAllToDo() {
        return toDoRepository.ToDoList();
    }

}
