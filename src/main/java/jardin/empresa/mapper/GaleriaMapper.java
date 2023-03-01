package jardin.empresa.mapper;

import jardin.empresa.DTO.GaleriaDTO;
import jardin.empresa.model.Galeria;
import jardin.empresa.repository.GaleriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        Galeria galeria = galeriaRepository.findById(id).get();
        galeria.setName(galeriaDTO.getName());
        galeria.setImagen(galeriaDTO.getImagen());
        galeria.setAlternativo(galeriaDTO.getAlternativo());
        return galeria;
    }
}
