package com.REST.spring_boot.task;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for Tasks entity
// Extends JpaRepository to provide CRUD operations
public interface TasksRepository
    extends JpaRepository<Tasks, Long>
{
}
