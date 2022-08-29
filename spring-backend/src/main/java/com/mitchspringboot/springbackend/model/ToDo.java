package com.mitchspringboot.springbackend.model;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "todolist")

public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "completed", nullable = false)
    private Boolean completed;
}
