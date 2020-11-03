package ru.ma3x.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ma3x.rest.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
