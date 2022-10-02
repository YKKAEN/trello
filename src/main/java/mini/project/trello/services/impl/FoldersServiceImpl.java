package mini.project.trello.services.impl;

import mini.project.trello.entities.Folders;
import mini.project.trello.repositories.FoldersRepository;
import mini.project.trello.services.FoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoldersServiceImpl implements FoldersService {

    @Autowired
    private FoldersRepository foldersRepository;

    @Override
    public Folders addFolder(Folders folder) {
        return foldersRepository.save(folder);
    }

    @Override
    public List<Folders> getAllFolders() {
        return foldersRepository.findAll();
    }

    @Override
    public Folders getFolder(Long id) {
        return foldersRepository.getById(id);
    }

    @Override
    public void deleteFolder(Folders folder) {
        foldersRepository.delete(folder);
    }

    @Override
    public Folders saveFolder(Folders folder) {
        return foldersRepository.save(folder);

    }
}
