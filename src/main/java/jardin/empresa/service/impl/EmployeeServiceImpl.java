package jardin.empresa.service.impl;

import jardin.empresa.DTO.EmployeeDTO;
import jardin.empresa.exception.GenericException;
import jardin.empresa.mapper.EmployeeMapper;
import jardin.empresa.model.Employee;
import jardin.empresa.repository.EmployeeRepository;
import jardin.empresa.service.EmployeeService;
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
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private CloudinaryServiceImpl cloudinaryService;
    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO, MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null){
            throw new GenericException("Image no acceptable", HttpStatus.NOT_ACCEPTABLE);
        }
        Employee employee = employeeMapper.dtoToEntity(employeeDTO, multipartFile);
        Employee saved = employeeRepository.save(employee);
        return employeeMapper.entityToDto(saved);
    }
    @Override
    public EmployeeDTO get(Long id) {
            Employee employee = employeeRepository.findById(id).orElseThrow();
            return employeeMapper.entityToDto(employee);
    }
    @Override
    public void delete(Long id) throws IOException {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        Map result = cloudinaryService.delete(employee.getImageId());
        employeeRepository.delete(employee);
    }
    @Override
    public EmployeeDTO put(Long id, EmployeeDTO employeeDTO, MultipartFile multipartFile) throws IOException {
        Employee employee = employeeMapper.updateEntity(id, employeeDTO, multipartFile);
        Employee saved = employeeRepository.save(employee);
        return employeeMapper.entityToDto(saved);
    }
    @Override
    public List<EmployeeDTO> getList() {
        List<Employee> list = employeeRepository.findAll();
        return employeeMapper.listEntityDto(list);
    }

}
