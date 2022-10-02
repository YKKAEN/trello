package mini.project.trello.controller;
import mini.project.trello.entities.Folders;
import mini.project.trello.entities.Tasks;
import mini.project.trello.repositories.FoldersRepository;
import mini.project.trello.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trello")
public class TasksController {

    @Autowired
    FoldersRepository foldersRepository;
    @Autowired
    TasksRepository tasksRepository;

    @GetMapping(value = "/tasks")
    public String tasks(Model model) {
        List<Folders> folders = foldersRepository.findAll();
        model.addAttribute("folders", folders);
        List<Tasks> tasks = tasksRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "/details";
    }
    @PostMapping(value = "/addnewtask")
    public String addtask(Model model, @RequestParam(name = "titleName") String titleName,
                          @RequestParam(name = "taskDescription") String taskDescription) {
        Tasks task = new Tasks();
        task.setTasksTitle(titleName);
        task.setTasksDescription(taskDescription);
        tasksRepository.save(task);
        return "redirect:/trello/details";
    }
}