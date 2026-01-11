package com.REST.spring_boot.task;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST controller to handle HTTP requests related to Tasks
@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TasksController {
    private final TasksService TasksService;

    public TasksController(TasksService TasksService) {
        this.TasksService = TasksService;
    }

    @GetMapping
    public List<Tasks> getTasks(Authentication authentication) {
        System.out.println(authentication.getName());
        return TasksService.getAllTasks();
    }

    @PostMapping
    public Tasks createTask(@RequestBody Tasks task) {
        return TasksService.createTask(task);
    }
}
