package jardin.empresa.service.impl;

import jardin.empresa.DTO.EmpresaDTO;
import jardin.empresa.mapper.EmpresaMapper;
import jardin.empresa.model.Empresa;
import jardin.empresa.repository.EmpresaRepository;
import jardin.empresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaMapper empresaMapper;

    @Override
    public EmpresaDTO save(EmpresaDTO empresaDTO) {
        Empresa empresa = empresaMapper.dtoToEntity(empresaDTO);
        Empresa saved = empresaRepository.save(empresa);
        EmpresaDTO dto = empresaMapper.entityToDto(saved);
        return dto;
    }

    @Override
    public EmpresaDTO get(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        EmpresaDTO dto = empresaMapper.entityToDto(empresa.get());
        return dto;
    }

    @Override
    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public EmpresaDTO put(Long id, EmpresaDTO empresaDTO) {
        Empresa empresa = empresaMapper.updateEntity(id, empresaDTO);
        Empresa saved = empresaRepository.save(empresa);
        EmpresaDTO dto = empresaMapper.entityToDto(saved);
        return dto;
    }
}
