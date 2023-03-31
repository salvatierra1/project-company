package jardin.empresa.controller;

import jardin.empresa.DTO.ProjectDTO;
import jardin.empresa.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping()
    public ResponseEntity<ProjectDTO> save(@Valid @RequestBody ProjectDTO projectDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.save(projectDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO>get(@Valid @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(projectService.get(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProjectDTO>delete(@Valid @PathVariable Long id){
        projectService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProjectDTO>put(@Valid @PathVariable Long id, @Valid @RequestBody ProjectDTO projectDTO){
        return ResponseEntity.status(HttpStatus.OK).body(projectService.put(id, projectDTO));
    }
    @GetMapping("/all")
    public ResponseEntity<List<ProjectDTO>>getList(){
        List<ProjectDTO> list = projectService.getList();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
