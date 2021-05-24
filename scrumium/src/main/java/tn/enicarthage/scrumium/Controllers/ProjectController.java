package tn.enicarthage.scrumium.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.enicarthage.scrumium.Domain.Project;
import tn.enicarthage.scrumium.Services.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @GetMapping("/all")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();}
    @PostMapping
    public String addProject(@RequestBody Project project){
        return projectService.addProject(project);
    }
    @GetMapping(path="{projectName}")
    public Project getProjectByName(@PathVariable String projectName){
        return projectService.getProjectByName(projectName);
    }
    @GetMapping(path="/id/{projectId}")
    public Project getProjectById(@PathVariable Long projectId){
        return projectService.getProjectById(projectId);
    }
    @PutMapping("{projectId}")
    public String updateProject(@PathVariable Long projectId,@RequestBody(required = false) Project project){
        projectService.updateProject(projectId,project);
        return "Project Updated";
    }
    @DeleteMapping(path="{projectId}")
    public String deleteProject(@PathVariable Long projectId){
        projectService.deleteProject(projectId);
        return "Project "+projectId+" Deleted";
    }
}
