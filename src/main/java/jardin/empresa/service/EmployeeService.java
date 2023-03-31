package jardin.empresa.service;

import jardin.empresa.DTO.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO save(EmployeeDTO employeeDTO);
    EmployeeDTO get(Long id);
    void delete(Long id);
    EmployeeDTO put(Long id, EmployeeDTO employeeDTO);
    List<EmployeeDTO> getList();
}
