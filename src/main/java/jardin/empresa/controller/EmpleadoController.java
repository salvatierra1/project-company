package jardin.empresa.controller;

import jardin.empresa.DTO.EmpleadoDTO;
import jardin.empresa.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping()
    public ResponseEntity<EmpleadoDTO> save(@RequestBody EmpleadoDTO empleadoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoService.save(empleadoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO>get(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpleadoDTO>delete(@PathVariable Long id){
        empleadoService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO>put(@PathVariable Long id, @RequestBody EmpleadoDTO empleadoDTO){
        return ResponseEntity.status(HttpStatus.OK).body(empleadoService.put(id, empleadoDTO));
    }

}
