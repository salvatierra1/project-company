package jardin.empresa.mapper;

import jardin.empresa.DTO.GaleriaDTO;
import jardin.empresa.exception.NotFoundException;
import jardin.empresa.model.Galeria;
import jardin.empresa.repository.GaleriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GaleriaMapper {

    @Autowired
    private GaleriaRepository galeriaRepository;

    public Galeria dtoToEntity(GaleriaDTO galeriaDTO) {
        Galeria galeria = new Galeria();
        galeria.setName(galeriaDTO.getName());
        galeria.setImagen(galeriaDTO.getImagen());
        galeria.setAlternativo(galeriaDTO.getAlternativo());
        return galeria;
    }

    public GaleriaDTO entityToDto(Galeria saved) {
        GaleriaDTO galeriaDTO = new GaleriaDTO();
        galeriaDTO.setId(saved.getId());
        galeriaDTO.setName(saved.getName());
        galeriaDTO.setImagen(saved.getImagen());
        galeriaDTO.setAlternativo(saved.getAlternativo());
        return galeriaDTO;
    }

    public Galeria updateEntity(Long id, GaleriaDTO galeriaDTO) {
        Optional<Galeria> galeria = galeriaRepository.findById(id);
        if(!galeria.isPresent()){
            throw new NotFoundException("No existe galeria: " + id);
        }
        galeria.get().setName(galeriaDTO.getName());
        galeria.get().setImagen(galeriaDTO.getImagen());
        galeria.get().setAlternativo(galeriaDTO.getAlternativo());
        return galeria.get();
    }

    public List<GaleriaDTO> listEntityDto(List<Galeria> listGaleria) {
       return  listGaleria.stream().map(g->entityToDto(g)).collect(Collectors.toList());
    }
}
