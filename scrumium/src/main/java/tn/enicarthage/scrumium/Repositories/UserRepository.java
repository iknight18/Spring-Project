package tn.enicarthage.scrumium.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enicarthage.scrumium.Domain.Sprint;
@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String username);
}
