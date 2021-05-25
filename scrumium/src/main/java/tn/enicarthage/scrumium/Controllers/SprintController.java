package tn.enicarthage.scrumium.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.scrumium.Domain.Sprint;
import tn.enicarthage.scrumium.Services.SprintService;

@RestController
public class SprintController {
    private final SprintService sprintService;
    @Autowired
    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }
}
