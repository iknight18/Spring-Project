package tn.enicarthage.scrumium.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enicarthage.scrumium.Domain.Sprint;
@Repository
public interface SprintRepository extends JpaRepository<Sprint,Long> {

}
