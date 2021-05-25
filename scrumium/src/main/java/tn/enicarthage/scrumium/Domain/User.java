package tn.enicarthage.scrumium.Domain;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class User implements Serializable{
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
    @column(name = "username", nullable = false, unique = true)
    private String username;
    @column(name = "password", nullable = false)
    private String password;
    @column(name = "first_name", nullable = false)
    private String firstName;
    @column(name = "last_name", nullable = false)
    private String lastName;
    @Email
    @column(name = "email", nullable = false, unique = true)
    private String email;
}
