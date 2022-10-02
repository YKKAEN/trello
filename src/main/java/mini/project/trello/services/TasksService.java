package mini.project.trello.services;

import mini.project.trello.entities.Tasks;

import java.util.List;

public interface TasksService {

    Tasks addTask(Tasks task);

    List<Tasks> getAllTasks();

    Tasks getTask(Long id);

    void deleteTask(Tasks task);

    Tasks saveTask(Tasks task);

}
