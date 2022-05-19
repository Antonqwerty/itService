package com.example.demo.mvc.domain;

import javax.persistence.*;

@Entity
@Table(name = "TASK2")
public class Task2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
}
