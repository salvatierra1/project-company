package jardin.empresa.service;

import jardin.empresa.DTO.ProyectoDTO;

public interface ProyectoService {

    ProyectoDTO save(ProyectoDTO proyectoDTO);

    ProyectoDTO get(Long id);

    void delete(Long id);
    ProyectoDTO put(Long id, ProyectoDTO proyectoDTO);
}
