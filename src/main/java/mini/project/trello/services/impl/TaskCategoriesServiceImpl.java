package mini.project.trello.services.impl;

import mini.project.trello.entities.TaskCategories;
import mini.project.trello.repositories.TaskCategoriesRepository;
import mini.project.trello.services.TaskCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskCategoriesServiceImpl implements TaskCategoriesService {

    @Autowired
    private TaskCategoriesRepository taskCategoriesRepository;

    @Override
    public TaskCategories addTaskCategory(TaskCategories taskCategory) {
        return taskCategoriesRepository.save(taskCategory);
    }

    @Override
    public List<TaskCategories> getAllTaskCategories() {
        return taskCategoriesRepository.findAll();
    }

    @Override
    public TaskCategories getTaskCategory(Long id) {
        return taskCategoriesRepository.getById(id);
    }

    @Override
    public void deleteTaskCategory(TaskCategories taskCategory) {
        taskCategoriesRepository.delete(taskCategory);
    }

    @Override
    public TaskCategories saveCategory(TaskCategories taskCategory) {
        return taskCategoriesRepository.save(taskCategory);

    }
}
