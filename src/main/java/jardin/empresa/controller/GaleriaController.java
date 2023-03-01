package jardin.empresa.controller;

import jardin.empresa.DTO.GaleriaDTO;
import jardin.empresa.service.GaleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/galeria")
public class GaleriaController {

    @Autowired
    private GaleriaService galeriaService;

    @PostMapping()
    public ResponseEntity<GaleriaDTO> save(@RequestBody GaleriaDTO galeriaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(galeriaService.save(galeriaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GaleriaDTO>get(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(galeriaService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GaleriaDTO>delete(@PathVariable Long id){
        galeriaService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GaleriaDTO>put(@PathVariable Long id, @RequestBody GaleriaDTO galeriaDTO){
        return ResponseEntity.status(HttpStatus.OK).body(galeriaService.put(id, galeriaDTO));
    }

}
