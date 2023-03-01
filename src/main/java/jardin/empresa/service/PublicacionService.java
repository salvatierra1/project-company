package jardin.empresa.service;

import jardin.empresa.DTO.PublicacionDTO;

public interface PublicacionService {

    PublicacionDTO save(PublicacionDTO publicacionDTO);

    PublicacionDTO get(Long id);

    void delete(Long id);

    PublicacionDTO put(Long id, PublicacionDTO publicacionDTO);
}
