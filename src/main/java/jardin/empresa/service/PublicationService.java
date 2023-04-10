package jardin.empresa.service;

import jardin.empresa.DTO.PublicationDTO;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface PublicationService {
    PublicationDTO save(PublicationDTO publicationDTO, MultipartFile multipartFile) throws IOException;
    PublicationDTO get(Long id);
    void delete(Long id) throws IOException;
    PublicationDTO put(Long id, PublicationDTO publicationDTO, MultipartFile multipartFile) throws IOException;
    List<PublicationDTO> getList();
    List<PublicationDTO> getListRelevant();
}
