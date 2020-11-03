package ru.ma3x.rest.services;

import org.springframework.stereotype.Service;
import ru.ma3x.rest.model.Task;
import ru.ma3x.rest.repository.TaskRepository;

@Service
public class TasksServiceImpl extends BaseServiceImpl<Task, TaskRepository> implements TasksService {

    public TasksServiceImpl(TaskRepository repository) {
        super(repository);
    }

}
