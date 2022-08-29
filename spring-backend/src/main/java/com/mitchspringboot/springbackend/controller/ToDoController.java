package com.mitchspringboot.springbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(path = "/todoadd", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ToDo> addToDo(@RequestBody ToDo newToDo) throws Exception {
        toDoRepository.ToDoAdd(newToDo.getTitle(), false);

        return new ResponseEntity<ToDo>(newToDo, HttpStatus.CREATED);
    }
}
