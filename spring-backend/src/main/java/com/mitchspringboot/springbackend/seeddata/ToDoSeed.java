package com.mitchspringboot.springbackend.seeddata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mitchspringboot.springbackend.model.ToDo;
import com.mitchspringboot.springbackend.repository.ToDoRepository;

@Component
public class ToDoSeed implements CommandLineRunner {
    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public void run(String... args) throws Exception {
        loadToDoList();
    }

    private void loadToDoList() {
        if (toDoRepository.count() == 0) {
            for (int i = 0; i < 5; i++) {
                toDoRepository.save(new ToDo(i + 1, "task" + i, (i % 2) < 1));

            }
        }
    }
}
