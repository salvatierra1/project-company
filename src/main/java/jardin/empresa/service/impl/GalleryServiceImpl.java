package jardin.empresa.service.impl;

import jardin.empresa.DTO.GalleryDTO;
import jardin.empresa.exception.GenericException;
import jardin.empresa.mapper.GalleryMapper;
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
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;

    private static final int SIZE_TEN = 10;
    @Autowired
    private CloudinaryServiceImpl cloudinaryService;

    @Autowired
    private GalleryMapper galleryMapper;
    @Override
    public GalleryDTO save(GalleryDTO galleryDTO, MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null){
            throw new GenericException("Image no acceptable", HttpStatus.NOT_ACCEPTABLE);
        }
        Gallery gallery = galleryMapper.dtoToEntity(galleryDTO, multipartFile);
        Gallery saved = galleryRepository.save(gallery);
        return galleryMapper.entityToDto(saved);
    }
    @Override
    public Page<Gallery> page(Pageable pageable) {
        return galleryRepository.findAll(pageable);
    }
    @Override
    public void delete(Long id) throws IOException {
        Gallery gallery = galleryRepository.findById(id).orElseThrow();
        Map result = cloudinaryService.delete(gallery.getImageId());
        galleryRepository.delete(gallery);
    }
}
