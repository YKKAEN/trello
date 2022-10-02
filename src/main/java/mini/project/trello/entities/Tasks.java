package mini.project.trello.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tasksTitle")
    private String tasksTitle;

    @Column(name = "tasksDescription")
    private String tasksDescription;

    @Column(name = "tasksStatus")
    private int tasksStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    private Folders folder;
}
