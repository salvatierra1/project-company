package jardin.empresa.service;

import jardin.empresa.DTO.PublicationDTO;

import java.util.List;

public interface PublicationService {
    PublicationDTO save(PublicationDTO publicationDTO);
    PublicationDTO get(Long id);
    void delete(Long id);
    PublicationDTO put(Long id, PublicationDTO publicationDTO);
    List<PublicationDTO> getList();
    List<PublicationDTO> getListRelevant();
}
