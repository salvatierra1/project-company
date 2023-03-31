package jardin.empresa.mapper;

import jardin.empresa.DTO.ProjectDTO;
import jardin.empresa.model.Project;
import jardin.empresa.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProjectMapper {

    @Autowired
    private ProjectRepository projectRepository;

    public Project dtoToEntity(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setBiography(projectDTO.getBiography());
        project.setImage(projectDTO.getImage());
        return project;
    }

    public ProjectDTO entityToDto(Project saved) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(saved.getId());
        projectDTO.setName(saved.getName());
        projectDTO.setBiography(saved.getBiography());
        projectDTO.setImage(saved.getImage());
        return projectDTO;
    }

    public Project updateEntity(Long id, ProjectDTO projectDTO) {
        Project project = projectRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        project.setName(projectDTO.getName());
        project.setBiography(projectDTO.getBiography());
        project.setImage(projectDTO.getImage());
        return project;
    }

    public List<ProjectDTO> listEntityDto(List<Project> projects) {
        return projects.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
