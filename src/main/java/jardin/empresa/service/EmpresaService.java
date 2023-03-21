package jardin.empresa.service;

import jardin.empresa.DTO.EmpresaDTO;

import java.util.List;

public interface EmpresaService {
    EmpresaDTO save(EmpresaDTO empresaDTO);
    EmpresaDTO get(Long id);
    void delete(Long id);
    EmpresaDTO put(Long id, EmpresaDTO empresaDTO);

    List<EmpresaDTO> getList();
}
