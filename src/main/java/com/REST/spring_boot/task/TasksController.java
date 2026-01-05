package com.REST.spring_boot.task;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Tasks> getTasks() {
        return TasksService.getAllTasks();
    }
}
