package com.mitchspringboot.springbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mitchspringboot.springbackend.model.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM todolist ")
    List<ToDo> ToDoList();

    @Query(nativeQuery = true, value = "Select * FROM todolist WHERE id=:id")
    ToDo GetToDoById(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO todolist (title, completed) values (:title, :completed)")
    Integer ToDoAdd(
            @Param("title") String title,
            @Param("completed") Boolean completed);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE todolist SET completed values :completed WHERE id=:id")
    Integer ToDoChangeCompletedStatus(@Param("id") Integer id, @Param("completed") Boolean completed);

}
