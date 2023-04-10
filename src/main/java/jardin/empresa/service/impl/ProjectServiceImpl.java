package jardin.empresa.service.impl;

import jardin.empresa.DTO.ProjectDTO;
import jardin.empresa.exception.GenericException;
import jardin.empresa.mapper.ProjectMapper;
import jardin.empresa.model.Project;
import jardin.empresa.repository.ProjectRepository;
import jardin.empresa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private CloudinaryServiceImpl cloudinaryService;

    @Override
    public ProjectDTO save(ProjectDTO projectDTO, MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null){
            throw new GenericException("Image no acceptable", HttpStatus.NOT_ACCEPTABLE);
        }
        Project project = projectMapper.dtoToEntity(projectDTO, multipartFile);
        Project saved = projectRepository.save(project);
        return projectMapper.entityToDto(saved);
    }
    @Override
    public ProjectDTO get(Long id) {
        Project project = projectRepository.findById(id).orElseThrow();
        return projectMapper.entityToDto(project);
    }
    @Override
    public void delete(Long id) throws IOException {
        Project project = projectRepository.findById(id).orElseThrow();
        Map result = cloudinaryService.delete(project.getImageId());
        projectRepository.delete(project);
    }
    @Override
    public ProjectDTO put(Long id, ProjectDTO projectDTO, MultipartFile multipartFile) throws IOException {
        Project project = projectMapper.updateEntity(id, projectDTO, multipartFile);
        Project saved = projectRepository.save(project);
        return projectMapper.entityToDto(saved);

    }
    @Override
    public List<ProjectDTO> getList() {
        List<Project> projects = projectRepository.findAll();
        return projectMapper.listEntityDto(projects);
    }

}
