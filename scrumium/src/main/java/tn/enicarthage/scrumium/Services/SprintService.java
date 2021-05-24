package tn.enicarthage.scrumium.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.scrumium.Repositories.SprintRepository;

@Service
public class SprintService {
    private final SprintRepository sprintRepository;
    @Autowired
    public SprintService(SprintRepository sprintRepository) {
        this.sprintRepository = sprintRepository;
    }
}
