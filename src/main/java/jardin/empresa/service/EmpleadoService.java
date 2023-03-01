package jardin.empresa.service;

import jardin.empresa.DTO.EmpleadoDTO;

public interface EmpleadoService {

    EmpleadoDTO save(EmpleadoDTO empleadoDTO);
    EmpleadoDTO get(Long id);
    void delete(Long id);
    EmpleadoDTO put(Long id, EmpleadoDTO empleadoDTO);
}
