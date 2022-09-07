package com.mitchspringboot.springbackend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mitchspringboot.springbackend.model.ToDo;
import com.mitchspringboot.springbackend.repository.ToDoRepository;

@ExtendWith(SpringExtension.class)
public class ToDoServiceTest {

    @Mock
    ToDoRepository toDoRepository;

    @InjectMocks
    ToDoService toDoService;

    private final Integer id = (int) Math.random() * 100;
    private final String title = "Task " + id;
    private final Boolean completed = false;

    private final ToDo expectedToDo = new ToDo(id, title, completed);

    @Test
    public void shouldGetAllToDoItems() {
        when(toDoRepository.ToDoList()).thenReturn(List.of(expectedToDo));

        List<ToDo> toDoList = toDoService.getAllToDo();
        assertEquals(1, toDoList.size());
        assertEquals(id, toDoList.get(0).getId());
        assertEquals(title, toDoList.get(0).getTitle());
        assertEquals(completed, toDoList.get(0).getCompleted());
    }

    // @Test
    // public void shouldCreateNewToDoItem() {
    // when(toDoRepository.ToDoAdd(eq(title),
    // eq(completed))).thenReturn(expectedToDo);

    // ToDo actualToDo = toDoService.addToDo(title, completed);

    // assertNotNull(expectedToDo.getId());
    // assertEquals(expectedToDo.getTitle(), actualToDo.getTitle());
    // assertEquals(expectedToDo.getCompleted(), actualToDo.getCompleted());
    // }
}
