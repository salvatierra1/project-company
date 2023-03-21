package jardin.empresa.service.impl;

import jardin.empresa.DTO.EmpresaDTO;
import jardin.empresa.exception.NotFoundException;
import jardin.empresa.mapper.EmpresaMapper;
import jardin.empresa.model.Empresa;
import jardin.empresa.repository.EmpresaRepository;
import jardin.empresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        if(!empresa.isPresent()){
            throw new NotFoundException("No existe la empresa: " + id);
        }
        EmpresaDTO dto = empresaMapper.entityToDto(empresa.get());
        return dto;
    }

    @Override
    public void delete(Long id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if(!empresa.isPresent()){
            throw new NotFoundException("No existe la empresa: " + id);
        }
        empresaRepository.deleteById(id);
    }

    @Override
    public EmpresaDTO put(Long id, EmpresaDTO empresaDTO) {
        Empresa empresa = empresaMapper.updateEntity(id, empresaDTO);
        Empresa saved = empresaRepository.save(empresa);
        EmpresaDTO dto = empresaMapper.entityToDto(saved);
        return dto;
    }

    @Override
    public List<EmpresaDTO> getList() {
        List<Empresa> listEmpresa = empresaRepository.findAll();
        List<EmpresaDTO> dto  = empresaMapper.listEntityDto(listEmpresa);
        return dto;
    }

}
