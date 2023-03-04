package jardin.empresa.service;

import jardin.empresa.DTO.GaleriaDTO;

import java.util.List;

public interface GaleriaService {
    GaleriaDTO save(GaleriaDTO galeriaDTO);
    GaleriaDTO get(Long id);
    void delete(Long id);
    GaleriaDTO put(Long id, GaleriaDTO galeriaDTO);
    List<GaleriaDTO> getPaginacion(Integer valueOf);

}
