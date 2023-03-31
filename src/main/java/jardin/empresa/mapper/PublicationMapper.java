package jardin.empresa.mapper;

import jardin.empresa.DTO.PublicationDTO;
import jardin.empresa.model.Publication;
import jardin.empresa.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PublicationMapper {
    @Autowired
    private PublicationRepository publicationRepository;

    public Publication dtoToEntity(PublicationDTO publicationDTO) {
        Publication publication = new Publication();
        publication.setBiography(publicationDTO.getBiography());
        publication.setImage(publicationDTO.getImage());
        publication.setRelevant(publicationDTO.isRelevant());
        return publication;
    }

    public PublicationDTO entityToDto(Publication saved) {
        PublicationDTO publicationDTO = new PublicationDTO();
        publicationDTO.setId(saved.getId());
        publicationDTO.setBiography(saved.getBiography());
        publicationDTO.setImage(saved.getImage());
        publicationDTO.setRelevant(saved.isRelevant());
        publicationDTO.setDate_creation(saved.getDate_creation());
        return publicationDTO;
    }

    public Publication updateEntity(Long id, PublicationDTO publicationDTO) {
        Publication publication = publicationRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        publication.setBiography(publicationDTO.getBiography());
        publication.setImage(publicationDTO.getImage());
        publication.setRelevant(publicationDTO.isRelevant());
        return publication;
    }

    public List<PublicationDTO> listEntityDto(List<Publication> listPublication) {
       return  listPublication.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<PublicationDTO> listEntityDtoRelevant(List<Publication> listPublication) {
        return  listPublication.stream().map(this::entityToDto).filter(a->a.isRelevant() == true).collect(Collectors.toList());
    }

}
