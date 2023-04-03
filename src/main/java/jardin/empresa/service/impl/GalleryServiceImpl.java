package jardin.empresa.service.impl;

import jardin.empresa.model.Gallery;
import jardin.empresa.repository.GalleryRepository;
import jardin.empresa.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;
import java.util.Map;


@Service
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;

    private static final int SIZE_TEN = 10;
    @Autowired
    CloudinaryServiceImpl cloudinaryService;
    @Override
    public Gallery save(MultipartFile multipartFile, String description, String relevant) throws IOException {
        Map result = cloudinaryService.upload(multipartFile);
        Gallery gallery = new Gallery(
                (String)result.get("original_filename"),
                (String) result.get("url"),
                (String) result.get("public_id"));
        gallery.setDescription(description);
        gallery.setRelevant(description);
        return galleryRepository.save(gallery);
    }

    @Override
    public Page<Gallery> page(Pageable pageable) {
        return galleryRepository.findAll(pageable);
    }
    @Override
    public void delete(Long id) throws IOException {
        Gallery gallery = galleryRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Map result = cloudinaryService.delete(gallery.getImageId());
        galleryRepository.delete(gallery);
    }
}
