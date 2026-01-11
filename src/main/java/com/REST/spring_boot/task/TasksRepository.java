package com.REST.spring_boot.task;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Repository interface for Tasks entity
// Extends JpaRepository to provide CRUD operations
public interface TasksRepository
    extends JpaRepository<Tasks, Long>
{
    List<Tasks> findByUserId(Long userId, Sort sort);
    // Custom method to find tasks by user ID
    Optional<Tasks> findByIdAndUserId(Integer id, Long userId);
    // Custom method to find a task by its ID and user ID
    void deleteByIdAndUserId(Integer id, Long userId);
    // Custom method to delete a task by its ID and user ID
}
