package mini.project.trello.services;

import mini.project.trello.entities.Folders;

import java.util.List;

public interface FoldersService {

    Folders addFolder(Folders folder);

    List<Folders> getAllFolders();

    Folders getFolder(Long id);

    void deleteFolder(Folders folder);

    Folders saveFolder(Folders folder);

}
