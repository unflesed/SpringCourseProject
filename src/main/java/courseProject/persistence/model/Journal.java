package courseProject.persistence.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "journal_name")
    private String journalName;
    private String genre;
    private String periodicity;
    private int cost;
    @ManyToMany(mappedBy = "journals")
    @Transient
    private List<User> users = new ArrayList<>();

    public Journal() {
    }
}
