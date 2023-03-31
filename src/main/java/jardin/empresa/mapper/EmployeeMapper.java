package jardin.empresa.mapper;

import jardin.empresa.DTO.EmployeeDTO;
import jardin.empresa.model.Employee;
import jardin.empresa.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee dtoToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setLast_name(employeeDTO.getLast_name());
        employee.setTitle(employeeDTO.getTitle());
        employee.setBiography(employeeDTO.getBiography());
        employee.setImage(employeeDTO.getImage());

        return employee;
    }

    public EmployeeDTO entityToDto(Employee saved) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(saved.getId());
        employeeDTO.setName(saved.getName());
        employeeDTO.setLast_name(saved.getLast_name());
        employeeDTO.setTitle(saved.getTitle());
        employeeDTO.setBiography(saved.getBiography());
        employeeDTO.setImage(saved.getImage());
        return employeeDTO;
    }
    public Employee updateEntity(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        employee.setName(employeeDTO.getName());
        employee.setName(employeeDTO.getName());
        employee.setLast_name(employeeDTO.getLast_name());
        employee.setTitle(employeeDTO.getTitle());
        employee.setBiography(employeeDTO.getBiography());
        employee.setImage(employeeDTO.getImage());
        return employee;
    }
    public List<EmployeeDTO> listEntityDto(List<Employee> listEmployees) {
        return  listEmployees.stream().map(this::entityToDto).collect(Collectors.toList());
    }
    
}
