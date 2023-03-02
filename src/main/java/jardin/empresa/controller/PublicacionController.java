package jardin.empresa.controller;

import jardin.empresa.DTO.PublicacionDTO;
import jardin.empresa.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/publicacion")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @PostMapping()
    public ResponseEntity<PublicacionDTO> save(@Valid @RequestBody PublicacionDTO publicacionDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(publicacionService.save(publicacionDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicacionDTO>get(@Valid @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(publicacionService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PublicacionDTO>delete(@Valid @PathVariable Long id){
        publicacionService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicacionDTO>put(@Valid @PathVariable Long id,@Valid @RequestBody PublicacionDTO publicacionDTO){
        return ResponseEntity.status(HttpStatus.OK).body(publicacionService.put(id, publicacionDTO));
    }

}
