package jardin.empresa.service.impl;

import jardin.empresa.DTO.PublicationDTO;
import jardin.empresa.mapper.PublicationMapper;
import jardin.empresa.model.Publication;
import jardin.empresa.repository.PublicationRepository;
import jardin.empresa.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PublicationServiceImpl implements PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private PublicationMapper publicationMapper;

    @Override
    public PublicationDTO save(PublicationDTO publicationDTO) {
        Publication publication = publicationMapper.dtoToEntity(publicationDTO);
        Publication saved = publicationRepository.save(publication);
        return publicationMapper.entityToDto(saved);
    }

    @Override
    public PublicationDTO get(Long id) {
        Publication publication = publicationRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        return publicationMapper.entityToDto(publication);
    }

    @Override
    public void delete(Long id) {
        Publication publication = publicationRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        publicationRepository.delete(publication);
    }

    @Override
    public PublicationDTO put(Long id, PublicationDTO publicationDTO) {
        Publication publication = publicationMapper.updateEntity(id, publicationDTO);
        Publication saved = publicationRepository.save(publication);
        return publicationMapper.entityToDto(saved);
    }

    @Override
    public List<PublicationDTO> getList() {
        List<Publication> listPublication = publicationRepository.findAll();
        return publicationMapper.listEntityDto(listPublication);
    }

    @Override
    public List<PublicationDTO> getListRelevant() {
        List<Publication> list = publicationRepository.findAll();
        return publicationMapper.listEntityDtoRelevant(list);
    }

}
