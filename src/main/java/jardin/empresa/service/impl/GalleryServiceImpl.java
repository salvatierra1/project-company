package jardin.empresa.service.impl;

import jardin.empresa.DTO.GalleryDTO;
import jardin.empresa.mapper.GalleryMapper;
import jardin.empresa.model.Gallery;
import jardin.empresa.repository.GalleryRepository;
import jardin.empresa.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;
    @Autowired
    private GalleryMapper galleryMapper;

    private static final int SIZE_TEN = 10;

    @Override
    public GalleryDTO save(GalleryDTO galleryDTO) {
        Gallery gallery = galleryMapper.dtoToEntity(galleryDTO);
        Gallery saved = galleryRepository.save(gallery);
        return galleryMapper.entityToDto(saved);
    }

    @Override
    public GalleryDTO get(Long id) {
        Gallery gallery = galleryRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return galleryMapper.entityToDto(gallery);
    }

    @Override
    public void delete(Long id) {
        Gallery gallery = galleryRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        galleryRepository.delete(gallery);
    }
    @Override
    public GalleryDTO put(Long id, GalleryDTO galleryDTO) {
        Gallery gallery = galleryMapper.updateEntity(id, galleryDTO);
        Gallery saved = galleryRepository.save(gallery);
        return galleryMapper.entityToDto(saved);
    }
    @Override
    public Page<Gallery> page(Pageable pageable) {
        return galleryRepository.findAll(pageable);
    }

}
