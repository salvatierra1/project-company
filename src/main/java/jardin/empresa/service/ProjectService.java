package jardin.empresa.service;

import jardin.empresa.DTO.ProjectDTO;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface ProjectService {
    ProjectDTO save(ProjectDTO projectDTO, MultipartFile multipartFile) throws IOException;
    ProjectDTO get(Long id);
    void delete(Long id) throws IOException;
    ProjectDTO put(Long id, ProjectDTO projectDTO, MultipartFile multipartFile) throws IOException;
    List<ProjectDTO> getList();
}
