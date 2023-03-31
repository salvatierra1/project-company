package jardin.empresa.controller;

import jardin.empresa.DTO.GalleryDTO;
import jardin.empresa.model.Gallery;
import jardin.empresa.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/gallery")
@CrossOrigin(origins = "http://localhost:3000")
public class GalleryController {
    @Autowired
    private GalleryService galleryService;
    @PostMapping()
    public ResponseEntity<GalleryDTO>create(@Valid @RequestBody GalleryDTO galleryDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(galleryService.save(galleryDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<GalleryDTO>get(@Valid @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(galleryService.get(id));
    }
    @GetMapping("/page")
    public ResponseEntity<Page<Gallery>> page(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "description") String order,
            @RequestParam(defaultValue = "true") boolean asc
    ){
        Page<Gallery> galleries = galleryService.page(
                PageRequest.of(page, size, Sort.by(order)));
        if(!asc)
            galleries = galleryService.page(
                    PageRequest.of(page, size, Sort.by(order).descending()));
        return new ResponseEntity(galleries, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GalleryDTO>update(@Valid @PathVariable Long id, @Valid @RequestBody GalleryDTO galleryDTO){
        return ResponseEntity.status(HttpStatus.OK).body(galleryService.put(id, galleryDTO));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<GalleryDTO>delete(@Valid @PathVariable Long id){
        galleryService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
