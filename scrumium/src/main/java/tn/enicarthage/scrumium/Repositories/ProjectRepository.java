package tn.enicarthage.scrumium.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.enicarthage.scrumium.Domain.Project;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    @Query("Select p FROM Project p WHERE p.name = ?1")
    Optional<Project> findByName(String name);
}
