package com.mitchspringboot.springbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitchspringboot.springbackend.model.ToDo;
import com.mitchspringboot.springbackend.repository.ToDoRepository;

@RestController
@RequestMapping("/api")
public class ToDoController {
    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping("/todolist")
    public List<ToDo> fetchToDo() {
        return toDoRepository.findAll();
    }
}
