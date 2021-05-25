package tn.enicarthage.scrumium.Domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Sprint {
    @Id
    @SequenceGenerator(
            name = "sprint_sequence",
            sequenceName = "sprint_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="sprint_sequence"
    )
    private Long id;
    private Integer number;
    private final LocalDate Timestamp = LocalDate.now();
    private Integer duration;
    private String Description;
    @ManyToOne()
    private Project project;

    @Override
    public String toString() {
        return "Sprint{" +
                "id=" + id +
                ", number=" + number +
                ", Timestamp=" + Timestamp +
                ", duration=" + duration +
                ", Description='" + Description + '\'' +
                ", project=" + project +
                '}';
    }
    @JsonIgnore
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Sprint(Integer number, Integer duration, String description, Project project) {
        this.number = number;
        this.duration = duration;
        Description = description;
        this.project = project;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getTimestamp() {
        return Timestamp;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Sprint() {
    }
}
