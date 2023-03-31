package jardin.empresa.service;

import jardin.empresa.DTO.ProjectDTO;

import java.util.List;

public interface ProjectService {
    ProjectDTO save(ProjectDTO projectDTO);
    ProjectDTO get(Long id);
    void delete(Long id);
    ProjectDTO put(Long id, ProjectDTO projectDTO);
    List<ProjectDTO> getList();
}
