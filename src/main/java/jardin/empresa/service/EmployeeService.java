package jardin.empresa.service;

import jardin.empresa.DTO.EmployeeDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    EmployeeDTO save(EmployeeDTO employeeDTO, MultipartFile multipartFile) throws IOException;
    EmployeeDTO get(Long id);
    void delete(Long id) throws IOException;
    EmployeeDTO put(Long id, EmployeeDTO employeeDTO, MultipartFile multipartFile) throws IOException;
    List<EmployeeDTO> getList();
}
