package jardin.empresa.controller;

import jardin.empresa.DTO.EmployeeDTO;
import jardin.empresa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping()
    public ResponseEntity<EmployeeDTO> save(@Valid @RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO>get(@Valid @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.get(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>>getList(){
        List<EmployeeDTO> list = employeeService.getList();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDTO>delete(@Valid @PathVariable Long id){
        employeeService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO>put(@Valid @PathVariable Long id, @Valid @RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.put(id, employeeDTO));
    }
}
