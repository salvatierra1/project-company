package jardin.empresa.service.impl;

import jardin.empresa.DTO.PublicationDTO;
import jardin.empresa.exception.GenericException;
import jardin.empresa.mapper.PublicationMapper;
import jardin.empresa.model.Publication;
import jardin.empresa.repository.PublicationRepository;
import jardin.empresa.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class PublicationServiceImpl implements PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private PublicationMapper publicationMapper;
    @Autowired
    private CloudinaryServiceImpl cloudinaryService;

    @Override
    public PublicationDTO save(PublicationDTO publicationDTO, MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null){
            throw new GenericException("Image no acceptable", HttpStatus.NOT_ACCEPTABLE);
        }
        Publication publication = publicationMapper.dtoToEntity(publicationDTO, multipartFile);
        Publication saved = publicationRepository.save(publication);
        return publicationMapper.entityToDto(saved);
    }
    @Override
    public PublicationDTO get(Long id) {
        Publication publication = publicationRepository.findById(id).orElseThrow();
        return publicationMapper.entityToDto(publication);
    }
    @Override
    public void delete(Long id) throws IOException {
        Publication publication = publicationRepository.findById(id).orElseThrow();
        Map result = cloudinaryService.delete(publication.getImageId());
        publicationRepository.delete(publication);
    }
    @Override
    public PublicationDTO put(Long id, PublicationDTO publicationDTO, MultipartFile multipartFile) throws IOException {
        Publication publication = publicationMapper.updateEntity(id, publicationDTO, multipartFile);
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
