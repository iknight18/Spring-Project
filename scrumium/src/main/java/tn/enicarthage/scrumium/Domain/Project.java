package tn.enicarthage.scrumium.Domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Project {
    @Id
    @SequenceGenerator(
            name = "project_sequence",
            sequenceName = "project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_sequence"
    )
    private Long id;
    private String name;
    private Integer velocity;
    private LocalDate TimeStamp = LocalDate.now();

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    private List<Sprint> sprintList;
    public Project() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project(Long id, String name, Integer velocity, List<Sprint> sprintList) {
        this.id = id;
        this.name = name;
        this.velocity = velocity;
        this.sprintList = sprintList;
        TimeStamp = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", velocity=" + velocity +
                ", TimeStamp=" + TimeStamp +
                ", sprintList=" + sprintList +
                '}';
    }

    public List<Sprint> getSprintList() {
        return sprintList;
    }

    public void setSprintList(List<Sprint> sprintList) {
        this.sprintList = sprintList;
    }

    public Project(String name, Integer velocity, List<Sprint> sprintList) {
        this.name = name;
        this.velocity = velocity;
        this.sprintList = sprintList;
        TimeStamp = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVelocity() {
        return velocity;
    }

    public void setVelocity(Integer velocity) {
        this.velocity = velocity;
    }

    public LocalDate getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        TimeStamp = timeStamp;
    }
}
