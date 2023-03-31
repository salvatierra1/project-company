package jardin.empresa.service.impl;

import jardin.empresa.DTO.ProjectDTO;
import jardin.empresa.mapper.ProjectMapper;
import jardin.empresa.model.Project;
import jardin.empresa.repository.ProjectRepository;
import jardin.empresa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public ProjectDTO save(ProjectDTO projectDTO) {
        Project project = projectMapper.dtoToEntity(projectDTO);
        Project saved = projectRepository.save(project);
        return projectMapper.entityToDto(saved);
    }
    @Override
    public ProjectDTO get(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        return projectMapper.entityToDto(project);
    }
    @Override
    public void delete(Long id) {
       Project project = projectRepository.findById(id).orElseThrow(()->
               new ResponseStatusException(HttpStatus.NOT_FOUND));
        projectRepository.delete(project);
    }
    @Override
    public ProjectDTO put(Long id, ProjectDTO projectDTO) {
        Project project = projectMapper.updateEntity(id, projectDTO);
        Project saved = projectRepository.save(project);
        return projectMapper.entityToDto(saved);

    }
    @Override
    public List<ProjectDTO> getList() {
        List<Project> projects = projectRepository.findAll();
        return projectMapper.listEntityDto(projects);
    }

}
