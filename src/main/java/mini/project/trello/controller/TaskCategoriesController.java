package mini.project.trello.controller;

import mini.project.trello.entities.Folders;
import mini.project.trello.entities.TaskCategories;
import mini.project.trello.repositories.CommentsRepository;
import mini.project.trello.repositories.FoldersRepository;
import mini.project.trello.repositories.TaskCategoriesRepository;
import mini.project.trello.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trello")

public class TaskCategoriesController {

    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    FoldersRepository foldersRepository;
    @Autowired
    TaskCategoriesRepository taskCategoriesRepository;
    @Autowired
    TasksRepository tasksRepository;

    @GetMapping(value = "/taskcategories")
    String getAllTaskCategories(Model model) {
        List<TaskCategories> taskCategories = taskCategoriesRepository.findAll();
        model.addAttribute("taskCategories", taskCategories);
        return "/taskCategories";
    }

    @PostMapping(value = "addtaskcategories")
    public String addTaskCategory(@RequestParam(name = "taskCategoryName") String taskCategoryName) {
        TaskCategories taskCategory = new TaskCategories();
        taskCategory.setTaskCategoriesName(taskCategoryName);
        taskCategoriesRepository.save(taskCategory);
        return "redirect:/trello/taskcategories";
    }

    @GetMapping(value = "/edittaskcategories/{id}")
    String getEditTaskCategoryForm(Model model,
                             @PathVariable(name = "id") Long id) {
        model.addAttribute("editTaskCategory", taskCategoriesRepository.findById(id).orElseThrow());
        return "editCategory";
    }

    @PostMapping(value = "/edittaskcategories/{id}")
    public String editTaskCategory(@ModelAttribute(name = "editTaskCategory") TaskCategories editTaskCategory,
                             @PathVariable(name = "id") Long id) {
        editTaskCategory.setId(id);
        taskCategoriesRepository.save(editTaskCategory);
        return "redirect:/trello/taskcategories";
    }

    @GetMapping(value = "/deletetaskcategory/{id}")
    public String deleteTaskCategory(@PathVariable(name = "id") Long id) {
        taskCategoriesRepository.deleteById(id);
        return "redirect:/trello/taskcategories";
    }
}
