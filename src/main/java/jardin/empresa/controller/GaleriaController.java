package jardin.empresa.controller;

import jardin.empresa.DTO.GaleriaDTO;
import jardin.empresa.service.GaleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/galeria")
public class GaleriaController {

    @Autowired
    private GaleriaService galeriaService;

    @PostMapping()
    public ResponseEntity<GaleriaDTO> save(@Valid @RequestBody GaleriaDTO galeriaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(galeriaService.save(galeriaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GaleriaDTO>get(@Valid @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(galeriaService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GaleriaDTO>delete(@Valid @PathVariable Long id){
        galeriaService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GaleriaDTO>put(@Valid @PathVariable Long id,@Valid @RequestBody GaleriaDTO galeriaDTO){
        return ResponseEntity.status(HttpStatus.OK).body(galeriaService.put(id, galeriaDTO));
    }

}
