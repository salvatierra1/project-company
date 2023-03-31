package jardin.empresa.mapper;

import jardin.empresa.DTO.GalleryDTO;
import jardin.empresa.model.Gallery;
import jardin.empresa.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GalleryMapper {

    @Autowired
    private GalleryRepository galleryRepository;

    public Gallery dtoToEntity(GalleryDTO galleryDTO) {
        Gallery gallery = new Gallery();
        gallery.setDescription(galleryDTO.getDescription());
        gallery.setImage(galleryDTO.getImage());
        gallery.setAlternative(galleryDTO.getAlternative());
        return gallery;
    }

    public GalleryDTO entityToDto(Gallery saved) {
        GalleryDTO galleryDTO = new GalleryDTO();
        galleryDTO.setId(saved.getId());
        galleryDTO.setDescription(saved.getDescription());
        galleryDTO.setImage(saved.getImage());
        galleryDTO.setAlternative(saved.getAlternative());
        return galleryDTO;
    }

    public Gallery updateEntity(Long id, GalleryDTO galleryDTO) {
        Gallery gallery = galleryRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        gallery.setDescription(galleryDTO.getDescription());
        gallery.setImage(galleryDTO.getImage());
        gallery.setAlternative(galleryDTO.getAlternative());
        return gallery;
    }

    public List<GalleryDTO> listEntityDto(List<Gallery> listGallery) {
       return  listGallery.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
