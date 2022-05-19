package com.example.demo.mvc.service;

import com.example.demo.mvc.domain.Task1;
import com.example.demo.mvc.dto.TaskInput;
import com.example.demo.mvc.respository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(TaskService.PREFIX + "1")
@RequiredArgsConstructor
public class Task1Service implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public String calcTask(TaskInput taskInput) {
        String[] firstArray = taskInput.getFirstArray().replace(" ", "").split(",");
        String[] secondArray = taskInput.getSecondArray().split(",");
        Set<String> result = new TreeSet<>();
        for (String first : firstArray) {
            for (String second : secondArray) {
                if (second.contains(first)) {
                    result.add(first);
                }
            }
        }
        return String.join(", ", result);
    }

    @Override
    public Task1 saveTask(TaskInput taskInput) {
        Task1 task1 = new Task1();
        task1.setFirstString(taskInput.getFirstArray());
        task1.setSecondString(taskInput.getSecondArray());
        return taskRepository.save(task1);
    }
}
