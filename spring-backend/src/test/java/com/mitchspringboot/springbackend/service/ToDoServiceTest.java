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

    private final ToDo mockToDo = new ToDo(id, title, completed);

    @Test
    public void shouldGetAllToDoItems() {
        when(toDoRepository.ToDoList()).thenReturn(List.of(mockToDo));

        List<ToDo> toDoList = toDoService.getAllToDo();
        assertEquals(1, toDoList.size());
        assertEquals(id, toDoList.get(0).getId());
        assertEquals(title, toDoList.get(0).getTitle());
        assertEquals(completed, toDoList.get(0).getCompleted());
    }

    @Test
    public void shouldCreateNewToDoItem() {
        when(toDoRepository.ToDoAdd(eq(title), eq(completed))).thenReturn(null);

        ToDo actualToDo = toDoService.addToDo(title, completed);

        System.out.println(List.of(mockToDo.getId(), mockToDo.getTitle(), mockToDo.getCompleted()));
        assertNotNull(mockToDo.getId());
        assertEquals(mockToDo.getTitle(), actualToDo.getTitle());
        assertEquals(mockToDo.getCompleted(), actualToDo.getCompleted());
    }

    @Test
    public void shouldBeChangedToCompletedWhenTrue() {
        when(toDoRepository.ToDoChangeCompletedStatus(eq(id), eq(completed))).thenReturn(null);
        when(toDoRepository.GetToDoById(eq(id))).thenReturn(new ToDo(id, title, !completed));

        ToDo updatedToDo = toDoService.changeCompletedStatus(mockToDo);

        assertEquals(!mockToDo.getCompleted(), updatedToDo.getCompleted());

    }
}
