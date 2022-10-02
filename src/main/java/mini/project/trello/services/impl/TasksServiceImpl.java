package mini.project.trello.services.impl;

import mini.project.trello.entities.Tasks;
import mini.project.trello.repositories.TasksRepository;
import mini.project.trello.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksServiceImpl implements TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    @Override
    public Tasks addTask(Tasks task) {
        return tasksRepository.save(task);
    }

    @Override
    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    @Override
    public Tasks getTask(Long id) {
        return tasksRepository.getById(id);
    }

    @Override
    public void deleteTask(Tasks task) {
        tasksRepository.delete(task);
    }

    @Override
    public Tasks saveTask(Tasks task) {
        return tasksRepository.save(task);

    }
}
