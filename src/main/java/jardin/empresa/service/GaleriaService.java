package jardin.empresa.service;

import jardin.empresa.DTO.GaleriaDTO;

public interface GaleriaService {
    GaleriaDTO save(GaleriaDTO galeriaDTO);
    GaleriaDTO get(Long id);

    void delete(Long id);

    GaleriaDTO put(Long id, GaleriaDTO galeriaDTO);
}
