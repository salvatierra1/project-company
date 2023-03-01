package jardin.empresa.service.impl;

import jardin.empresa.DTO.PublicacionDTO;
import jardin.empresa.mapper.PublicacionMapper;
import jardin.empresa.model.Publicacion;
import jardin.empresa.repository.PublicacionRepository;
import jardin.empresa.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PublicacionServiceImpl implements PublicacionService {
    @Autowired
    private PublicacionRepository publicacionRepository;
    @Autowired
    private PublicacionMapper publicacionMapper;

    @Override
    public PublicacionDTO save(PublicacionDTO publicacionDTO) {
        Publicacion publicacion = publicacionMapper.dtoToEntity(publicacionDTO);
        Publicacion saved = publicacionRepository.save(publicacion);
        PublicacionDTO dto = publicacionMapper.entityToDto(saved);
        return dto;
    }

    @Override
    public PublicacionDTO get(Long id) {
        Optional<Publicacion> publicacion = publicacionRepository.findById(id);
        PublicacionDTO dto = publicacionMapper.entityToDto(publicacion.get());
        return dto;
    }

    @Override
    public void delete(Long id) {
        publicacionRepository.deleteById(id);
    }

    @Override
    public PublicacionDTO put(Long id, PublicacionDTO publicacionDTO) {
        Publicacion publicacion = publicacionMapper.updateEntity(id, publicacionDTO);
        Publicacion saved = publicacionRepository.save(publicacion);
        PublicacionDTO dto = publicacionMapper.entityToDto(saved);
        return dto;
    }

}
