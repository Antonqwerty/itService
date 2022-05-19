package com.example.demo.mvc.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TASK1")
@Data
public class Task1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_STRING")
    private String firstString;

    @Column(name = "SECOND_STRING")
    private String secondString;
}
