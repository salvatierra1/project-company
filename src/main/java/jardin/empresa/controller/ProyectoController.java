package jardin.empresa.controller;

import jardin.empresa.DTO.ProyectoDTO;
import jardin.empresa.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping()
    public ResponseEntity<ProyectoDTO> save(@RequestBody ProyectoDTO proyectoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proyectoService.save(proyectoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO>get(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(proyectoService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProyectoDTO>delete(@PathVariable Long id){
        proyectoService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyectoDTO>put(@PathVariable Long id, @RequestBody ProyectoDTO proyectoDTO){
        return ResponseEntity.status(HttpStatus.OK).body(proyectoService.put(id, proyectoDTO));
    }

}
