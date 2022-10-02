package mini.project.trello.services;

import mini.project.trello.entities.TaskCategories;

import java.util.List;

public interface TaskCategoriesService {

    TaskCategories addTaskCategory(TaskCategories taskCategory);

    List<TaskCategories> getAllTaskCategories();

    TaskCategories getTaskCategory(Long id);

    void deleteTaskCategory(TaskCategories taskCategory);

    TaskCategories saveCategory(TaskCategories taskCategory);

}
