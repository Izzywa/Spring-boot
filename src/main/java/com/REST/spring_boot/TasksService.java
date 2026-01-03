package com.REST.spring_boot;

import org.springframework.stereotype.Service;
import java.util.List;

// Marking this class as a service component in Spring
// Able to hold business logic related to Tasks in the future
@Service
public class TasksService {
    private final TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }
}
