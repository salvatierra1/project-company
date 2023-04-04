package jardin.empresa.service.impl;

import jardin.empresa.model.Gallery;
import jardin.empresa.repository.GalleryRepository;
import jardin.empresa.service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;

    private static final int SIZE_TEN = 10;
    @Autowired
    CloudinaryServiceImpl cloudinaryService;
    @Override
    @Transactional
    public Gallery save(Gallery gallery, MultipartFile multipartFile) throws IOException {
        Map result = cloudinaryService.upload(multipartFile);
        Gallery gallery1 = new Gallery();
        gallery1.setName((String)result.get("original_filename"));
        gallery1.setImageUrl((String)result.get("url"));
        gallery1.setImageId((String)result.get("public_id"));
        gallery1.setDescription(gallery.getDescription());
        gallery1.setRelevant(gallery.getRelevant());
        return galleryRepository.save(gallery1);
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
