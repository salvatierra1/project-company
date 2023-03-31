package jardin.empresa.controller;

import jardin.empresa.DTO.PublicationDTO;
import jardin.empresa.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/publication")
@CrossOrigin(origins = "http://localhost:3000")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;
    @PostMapping()
    public ResponseEntity<PublicationDTO> save(@Valid @RequestBody PublicationDTO publicationDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(publicationService.save(publicationDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PublicationDTO>get(@Valid @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(publicationService.get(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PublicationDTO>delete(@Valid @PathVariable Long id){
        publicationService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<PublicationDTO>put(@Valid @PathVariable Long id, @Valid @RequestBody PublicationDTO publicationDTO){
        return ResponseEntity.status(HttpStatus.OK).body(publicationService.put(id, publicationDTO));
    }
    @GetMapping("/all")
    public ResponseEntity<List<PublicationDTO>>getList(){
        List<PublicationDTO> list = publicationService.getList();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping("/relevant")
    public ResponseEntity<List<PublicationDTO>> getListRelevant(){
        List<PublicationDTO> list = publicationService.getListRelevant();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
}
