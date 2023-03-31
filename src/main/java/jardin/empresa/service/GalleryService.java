package jardin.empresa.service;

import jardin.empresa.DTO.GalleryDTO;
import jardin.empresa.model.Gallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GalleryService {
    GalleryDTO save(GalleryDTO galleryDTO);
    GalleryDTO get(Long id);
    void delete(Long id);
    GalleryDTO put(Long id, GalleryDTO galleryDTO);
    Page<Gallery> page(Pageable pageable);
}
