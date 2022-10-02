package mini.project.trello.repositories;

import mini.project.trello.entities.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TaskCategoriesRepository  extends JpaRepository<TaskCategories, Long> {
}
