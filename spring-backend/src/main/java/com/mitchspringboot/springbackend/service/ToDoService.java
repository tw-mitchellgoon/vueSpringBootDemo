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

    public ToDo addToDo(String title, Boolean completed) {
        ToDo toDoItem = new ToDo((int) Math.random() * 100, title, completed);
        toDoRepository.ToDoAdd(toDoItem.getTitle(), toDoItem.getCompleted());
        return toDoItem;
    }

    public ToDo changeCompletedStatus(ToDo toDo) {
        toDoRepository.ToDoChangeCompletedStatus(toDo.getId(), !toDo.getCompleted());
        ToDo updatedToDoItem = toDoRepository.GetToDoById(toDo.getId());
        return updatedToDoItem;
    }

    public List<ToDo> getAllToDo() {
        return toDoRepository.ToDoList();
    }

    public ToDo getToDoById(Integer id) {
        return toDoRepository.GetToDoById(id);
    }

}
