package com.mitchspringboot.springbackend.controller;

import org.junit.jupiter.api.Test;

import com.mitchspringboot.springbackend.model.ToDo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ToDoControllerTest {
    @Test
    public void shouldGetAllToDoItems() {
        ToDoController toDoController = new ToDoController();
        List<ToDo> toDoList = toDoController.fetchToDo();
        assertNotNull(toDoList);
    }
}
