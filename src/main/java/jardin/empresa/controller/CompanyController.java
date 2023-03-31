package jardin.empresa.controller;

import jardin.empresa.DTO.CompanyDTO;
import jardin.empresa.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "http://localhost:3000")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping()
    public ResponseEntity<CompanyDTO>create(@Valid @RequestBody CompanyDTO companyDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.save(companyDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO>get(@Valid @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.get(id));
    }
    @GetMapping("/all")
    public ResponseEntity<List<CompanyDTO>>findAll(){
        List<CompanyDTO> list = companyService.getList();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CompanyDTO>update(@Valid @PathVariable Long id, @Valid @RequestBody CompanyDTO companyDTO){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.put(id, companyDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<CompanyDTO>delete(@Valid @PathVariable Long id){
        companyService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
