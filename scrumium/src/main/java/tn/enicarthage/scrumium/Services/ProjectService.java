package tn.enicarthage.scrumium.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.enicarthage.scrumium.Domain.Project;
import tn.enicarthage.scrumium.Repositories.ProjectRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public String addProject(Project project) {
            if(projectRepository.findByName(project.getName()).isPresent())
                throw new IllegalStateException("Project With name = "+ project.getName()+" exists Already!");
            projectRepository.save(project);
            return "Project "+project.getName()+" Added !";
    }

    public Project getProjectByName(String projectName) {
        Optional<Project> p = projectRepository.findByName(projectName);
        if (p.isEmpty()) throw new IllegalStateException("Project with name = "+projectName+" Does not exist");
        return p.get();
    }

    public Project getProjectById(Long projectId) {
        Optional<Project> p = projectRepository.findById(projectId);
        if (p.isEmpty()) throw new IllegalStateException("Project with Id = "+projectId+" Does not exist");
        return p.get();
    }
    @Transactional
    public void updateProject(Long projectId, Project project) {
        if(project==null) throw new IllegalStateException("Empty Request");
        Optional<Project> p = projectRepository.findById(projectId);
        if (p.isEmpty()) throw new IllegalStateException("Project with Id = "+projectId+" Does not exist");
        Project projectInit = p.get();
        if(project.getName()!=null){
            if(!project.getName().equals(projectInit.getName()) && project.getName().length()>0) {
                projectInit.setName(project.getName());
            }
        }
        if(project.getVelocity()!=null){
            projectInit.setVelocity(project.getVelocity());
        }
    }

    public void deleteProject(Long projectId) {
        boolean exists = projectRepository.existsById(projectId);
        if(!exists) throw new IllegalStateException("Project with id = " + projectId + " does not exists");
        projectRepository.deleteById(projectId);
    }
}
