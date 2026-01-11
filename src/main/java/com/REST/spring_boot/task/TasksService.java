package com.REST.spring_boot.task;

import com.REST.spring_boot.authentication.Users;
import com.REST.spring_boot.security.SecurityUtils;
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
        Users currentUser = SecurityUtils.getCurrentUser();
        return tasksRepository.findByUserId(currentUser.getId());
    }

    public Tasks createTask(Tasks task) {
        Users currentUser = SecurityUtils.getCurrentUser();
        task.setUser(currentUser);
        return tasksRepository.save(task);
    }
}
