package jardin.empresa.service;

import jardin.empresa.DTO.GalleryDTO;
import jardin.empresa.model.Gallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


public interface GalleryService {
    GalleryDTO save(GalleryDTO gallery, MultipartFile multipartFile) throws IOException;
    void delete(Long id) throws IOException;
    Page<Gallery> page(Pageable pageable);
}
