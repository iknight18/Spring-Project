package tn.enicarthage.scrumium.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.enicarthage.scrumium.Domain.Sprint;
import tn.enicarthage.scrumium.Domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query("select u from User u where u.username = ?1")
    Optional<User> findByUsername(String username);
}
