package jardin.empresa.service.impl;

import jardin.empresa.DTO.EmployeeDTO;
import jardin.empresa.mapper.EmployeeMapper;
import jardin.empresa.model.Employee;
import jardin.empresa.repository.EmployeeRepository;
import jardin.empresa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.dtoToEntity(employeeDTO);
        Employee saved = employeeRepository.save(employee);
        return employeeMapper.entityToDto(saved);
    }
    @Override
    public EmployeeDTO get(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        return employeeMapper.entityToDto(employee);
    }
    @Override
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        employeeRepository.delete(employee);
    }
    @Override
    public EmployeeDTO put(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.updateEntity(id, employeeDTO);
        Employee saved = employeeRepository.save(employee);
        return employeeMapper.entityToDto(saved);
    }
    @Override
    public List<EmployeeDTO> getList() {
        List<Employee> list = employeeRepository.findAll();
        return employeeMapper.listEntityDto(list);
    }

}
