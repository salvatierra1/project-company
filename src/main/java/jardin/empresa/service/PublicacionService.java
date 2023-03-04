package jardin.empresa.service;

import jardin.empresa.DTO.PublicacionDTO;

import java.util.List;

public interface PublicacionService {
    PublicacionDTO save(PublicacionDTO publicacionDTO);
    PublicacionDTO get(Long id);
    void delete(Long id);
    PublicacionDTO put(Long id, PublicacionDTO publicacionDTO);
    List<PublicacionDTO> getList();
    List<PublicacionDTO> getListDestacado();
}
