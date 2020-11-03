package ru.ma3x.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ma3x.rest.model.Task;
import ru.ma3x.rest.services.TasksService;

import java.util.List;

@RestController
public class TasksController {
    private final TasksService service;

    public TasksController(TasksService service) {
        this.service = service;
    }

    @PostMapping(value = "/tasks")
    public ResponseEntity<?> create(@RequestBody Task task) {
        service.create(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/tasks")
    public ResponseEntity<List<Task>> read() {
        final List<Task> tasks = service.getAll();

        return tasks != null && !tasks.isEmpty()
                ? new ResponseEntity<>(tasks, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tasks/{id}")
    public ResponseEntity<Task> read(@PathVariable(name = "id") long id) {
        final Task task = service.get(id);

        return task != null
                ? new ResponseEntity<>(task, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/tasks/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id,
                                    @RequestBody Task task) {
        Task oldTask = service.get(id);
        if (oldTask!= null){
            oldTask.setName(task.getName());
            oldTask.setDescription(task.getDescription());
        }
        task.setId(id);
        final boolean updated = service.update(task, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/tasks/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = service.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
