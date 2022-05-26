package com.example.demo.mvc.controller;

import com.example.demo.mvc.dto.TaskInput;
import com.example.demo.mvc.service.Task1Service;
import com.example.demo.mvc.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final Map<String, TaskService> taskServiceMap;
    private final Task1Service task1Service;


    @GetMapping
    public String getForm() {
        return "main";
    }

    @GetMapping("/{task}")
    public String getTaskForm(Model model, @PathVariable String task) {
        model.addAttribute("input", new TaskInput());
        return "task" + task;
    }

    @PostMapping(value = "/{task}", consumes = "application/x-www-form-urlencoded;charset=UTF-8", params = "action=calc")
    public String calcTask(Model model, TaskInput input, @PathVariable String task) {
        model.addAttribute("input", input);
        System.out.println(task);
        System.out.println(input);
        String result = taskServiceMap.get(TaskService.PREFIX + task).calcTask(input);
        model.addAttribute("result", result);
        return "task1";
    }

    @PostMapping(value = "/{task}", consumes = "application/x-www-form-urlencoded;charset=UTF-8", params = "action=save")
    public String saveToDb(Model model, TaskInput input, @PathVariable String task) {
        model.addAttribute("input", input);
        task1Service.saveTask(input);
        return "task1";
    }
}
