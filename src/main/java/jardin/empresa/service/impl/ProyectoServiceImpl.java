package jardin.empresa.service.impl;

import jardin.empresa.DTO.ProyectoDTO;
import jardin.empresa.mapper.ProyectoMapper;
import jardin.empresa.model.Proyecto;
import jardin.empresa.repository.ProyectoRepository;
import jardin.empresa.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private ProyectoMapper proyectoMapper;


    @Override
    public ProyectoDTO save(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = proyectoMapper.dtoToEntity(proyectoDTO);
        Proyecto saved = proyectoRepository.save(proyecto);
        ProyectoDTO dto = proyectoMapper.entityToDto(saved);
        return dto;
    }

    @Override
    public ProyectoDTO get(Long id) {
        Optional<Proyecto>proyecto = proyectoRepository.findById(id);
        ProyectoDTO dto = proyectoMapper.entityToDto(proyecto.get());
        return dto;
    }

    @Override
    public void delete(Long id) {
        proyectoRepository.deleteById(id);
    }

    @Override
    public ProyectoDTO put(Long id, ProyectoDTO proyectoDTO) {
        Proyecto proyecto = proyectoMapper.updateEntity(id, proyectoDTO);
        Proyecto saved = proyectoRepository.save(proyecto);
        ProyectoDTO dto = proyectoMapper.entityToDto(saved);
        return dto;
    }


}
