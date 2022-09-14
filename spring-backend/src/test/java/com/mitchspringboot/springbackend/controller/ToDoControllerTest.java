package com.mitchspringboot.springbackend.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.mitchspringboot.springbackend.model.ToDo;
import com.mitchspringboot.springbackend.service.ToDoService;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ToDoController.class)
public class ToDoControllerTest {

    public static final String TODO_REQUEST_PREFIX = "/api/";

    public static final String TODO_ADD_REQUEST_BODY = """
            {
                "title": "%s"
            }
            """;
    private final Integer id = (int) Math.random() * 100;
    private final String title = "Task " + id;
    private final Boolean completed = false;

    private final ToDo toDoItem = new ToDo(id, title, completed);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;

    @Test
    public void shouldGetAllToDoItems() throws Exception {
        Integer toDoId1 = (int) Math.random() * 100;
        String toDoTitle1 = "Task " + toDoId1;
        Boolean toDoCompleted1 = false;

        Integer toDoId2 = (int) Math.random() * 100;
        String toDoTitle2 = "Task " + toDoId2;
        Boolean toDoCompleted2 = true;

        ToDo expectedToDo1 = new ToDo(toDoId1, toDoTitle1, toDoCompleted1);
        ToDo expectedToDo2 = new ToDo(toDoId2, toDoTitle2, toDoCompleted2);

        List<ToDo> expectedToDoList = List.of(expectedToDo1, expectedToDo2);
        when(toDoService.getAllToDo()).thenReturn(expectedToDoList);

        mockMvc.perform(get(TODO_REQUEST_PREFIX + "todolist/")).andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].title").value(toDoTitle1))
                .andExpect(jsonPath("$.[1].title").value(toDoTitle2));
    }

    @Test
    public void shouldAddToDoItem() throws Exception {
        String toDoAddRequestJson = String.format(TODO_ADD_REQUEST_BODY, title, completed);
        when(toDoService.addToDo(eq(title), eq(completed))).thenReturn(toDoItem);
        when(toDoService.getAllToDo()).thenReturn(List.of(toDoItem));
        mockMvc.perform(post(TODO_REQUEST_PREFIX + "todoadd/").content(toDoAddRequestJson)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.completed").value(completed));
        verify(toDoService).addToDo(title, completed);
    }

    @Test
    public void shouldGetOneToDoItem() throws Exception {
        when(toDoService.getToDoById(eq(id))).thenReturn(toDoItem);
        mockMvc.perform(get(TODO_REQUEST_PREFIX + "todoitem/" + id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.completed").value(completed));
        verify(toDoService).getToDoById(id);
    }

    @Test
    public void shouldChangeStatusWhenCompletedIsChanged() throws Exception {
        ToDo updatedToDo = new ToDo(id, title, !completed);
        when(toDoService.changeCompletedStatus(eq(id))).thenReturn(updatedToDo);
        mockMvc.perform(patch(TODO_REQUEST_PREFIX +
                "todoupdate/" +
                id).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.completed").value(!completed));
        verify(toDoService).changeCompletedStatus(id);
    }
}
