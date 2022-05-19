package com.example.demo.mvc.service;

import com.example.demo.mvc.domain.Task1;
import com.example.demo.mvc.dto.TaskInput;

public interface TaskService {
    String PREFIX = "taskService";

    String calcTask(TaskInput taskInput);

    Task1 saveTask(TaskInput taskInput);
}
