package com.REST.spring_boot.task;

import com.REST.spring_boot.authentication.Users;
import com.REST.spring_boot.security.SecurityUtils;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import java.util.List;

// Marking this class as a service component in Spring
// Able to hold business logic related to Tasks in the future
@Service
public class TasksService {
    private final TasksRepository tasksRepository;
    private Users currentUser() {
        return SecurityUtils.getCurrentUser();
    }

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Tasks> getAllTasks() {
        return tasksRepository.findByUserId(
                currentUser().getId(),
                Sort.by(Sort.Direction.ASC, "id")
        );
    }

    public Tasks createTask(Tasks task) {
        task.setUser(currentUser());
        return tasksRepository.save(task);
    }

    public Tasks updateTask(Tasks task) {
        Tasks currentTask = tasksRepository.findByIdAndUserId(task.getId(), currentUser().getId())
                .orElseThrow(() -> new RuntimeException("Task not found"));
        currentTask.updateFrom(task);
        return tasksRepository.save(currentTask);
    }

    @Transactional
    public void deleteTask(Integer taskId) {
        tasksRepository.deleteByIdAndUserId(taskId, currentUser().getId());
    }
}
