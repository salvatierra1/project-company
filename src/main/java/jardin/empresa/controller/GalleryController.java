package jardin.empresa.controller;

import jardin.empresa.DTO.MessageDTO;
import jardin.empresa.model.Gallery;
import jardin.empresa.service.GalleryService;
import jardin.empresa.service.impl.CloudinaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
@RequestMapping("/gallery")
@CrossOrigin(origins = "http://localhost:3000")
public class GalleryController {
    @Autowired
    private GalleryService galleryService;

    @Autowired
    private CloudinaryServiceImpl cloudinaryService;

    @PostMapping()
    public ResponseEntity<?>upload(
            @RequestParam MultipartFile multipartFile,
            @RequestParam String description,
            @RequestParam String relevant) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if(bi == null){
           return  new ResponseEntity<>(new MessageDTO("invalid image"),HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(galleryService.save(multipartFile, description, relevant));
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
        return ResponseEntity.status(HttpStatus.OK).body(galleries);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id) throws IOException {
        galleryService.delete(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
