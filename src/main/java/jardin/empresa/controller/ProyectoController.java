package jardin.empresa.controller;

import jardin.empresa.DTO.ProyectoDTO;
import jardin.empresa.DTO.PublicacionDTO;
import jardin.empresa.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping()
    public ResponseEntity<ProyectoDTO> save(@Valid @RequestBody ProyectoDTO proyectoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proyectoService.save(proyectoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO>get(@Valid @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(proyectoService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProyectoDTO>delete(@Valid @PathVariable Long id){
        proyectoService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyectoDTO>put(@Valid @PathVariable Long id,@Valid @RequestBody ProyectoDTO proyectoDTO){
        return ResponseEntity.status(HttpStatus.OK).body(proyectoService.put(id, proyectoDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProyectoDTO>>getList(){
        List<ProyectoDTO> listProyecto = proyectoService.getList();
        return ResponseEntity.status(HttpStatus.OK).body(listProyecto);
    }

}
