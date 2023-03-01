package jardin.empresa.service.impl;

import jardin.empresa.DTO.GaleriaDTO;
import jardin.empresa.mapper.GaleriaMapper;
import jardin.empresa.model.Galeria;
import jardin.empresa.repository.GaleriaRepository;
import jardin.empresa.service.GaleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GaleriaServiceImpl implements GaleriaService {

    @Autowired
    private GaleriaRepository galeriaRepository;
    @Autowired
    private GaleriaMapper galeriaMapper;

    @Override
    public GaleriaDTO save(GaleriaDTO galeriaDTO) {
        Galeria galeria = galeriaMapper.dtoToEntity(galeriaDTO);
        Galeria saved = galeriaRepository.save(galeria);
        GaleriaDTO dto = galeriaMapper.entityToDto(saved);
        return dto;
    }

    @Override
    public GaleriaDTO get(Long id) {
        Optional<Galeria> galeria = galeriaRepository.findById(id);
        GaleriaDTO dto = galeriaMapper.entityToDto(galeria.get());
        return dto;
    }

    @Override
    public void delete(Long id) {
        galeriaRepository.deleteById(id);
    }

    @Override
    public GaleriaDTO put(Long id, GaleriaDTO galeriaDTO) {
        Galeria galeria = galeriaMapper.updateEntity(id, galeriaDTO);
        Galeria saved = galeriaRepository.save(galeria);
        GaleriaDTO dto = galeriaMapper.entityToDto(saved);
        return dto;
    }


}
