package jardin.empresa.service;

import jardin.empresa.DTO.GaleriaDTO;
import jardin.empresa.model.Galeria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GaleriaService {
    GaleriaDTO save(GaleriaDTO galeriaDTO);
    GaleriaDTO get(Long id);
    void delete(Long id);
    GaleriaDTO put(Long id, GaleriaDTO galeriaDTO);
    Page<Galeria> paginas(Pageable pageable);
}
