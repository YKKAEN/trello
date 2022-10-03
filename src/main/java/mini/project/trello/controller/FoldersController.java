package mini.project.trello.controller;

import mini.project.trello.entities.Folders;
import mini.project.trello.repositories.CommentsRepository;
import mini.project.trello.repositories.FoldersRepository;
import mini.project.trello.repositories.TaskCategoriesRepository;
import mini.project.trello.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/trello")
public class FoldersController {

    @Autowired
    CommentsRepository commentsRepository;
    @Autowired
    FoldersRepository foldersRepository;
    @Autowired
    TaskCategoriesRepository taskCategoriesRepository;
    @Autowired
    TasksRepository tasksRepository;

    @GetMapping(value = "/index")
    public String getAllFolders(Model model) {
        List<Folders> folders = foldersRepository.findAll();
        model.addAttribute("folders", folders);
        return "index";
    }

    @PostMapping(value = "addfolder")
    public String addFolder(@RequestParam(name = "folderName") String folderName) {
        Folders folder = new Folders();
        folder.setFoldersName(folderName);
        foldersRepository.save(folder);
        return "redirect:/trello/index";
    }

    @GetMapping(value = "/details/{id}")
    public String details(Model model, @PathVariable(name = "id") Long id) {
        Folders folder = foldersRepository.findById(id).orElseThrow();
        model.addAttribute("folder", folder);
        return "details";
    }

    @GetMapping(value = "/editfolder/{id}")
    String getEditFolderForm(Model model,
                             @PathVariable(name = "id") Long id) {
        model.addAttribute("editFolder", foldersRepository.findById(id).orElseThrow());
        return "editFolder";
    }

    @PostMapping(value = "/editfolder/{id}")
    public String editFolder(@ModelAttribute(name = "editFolder") Folders editFolder,
                      @PathVariable(name = "id") Long id) {
        editFolder.setId(id);
        foldersRepository.save(editFolder);
        return "redirect:/trello/index";
    }

    @GetMapping(value = "/deletefolder/{id}")
    public String deleteFolder(@PathVariable(name = "id") Long id) {
        foldersRepository.deleteById(id);
        return "redirect:/trello/index";
    }
}