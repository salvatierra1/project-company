package jardin.empresa.mapper;

import jardin.empresa.DTO.PublicacionDTO;
import jardin.empresa.exception.NotFoundException;
import jardin.empresa.model.Publicacion;
import jardin.empresa.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PublicacionMapper {


    @Autowired
    private PublicacionRepository publicacionRepository;

    public Publicacion dtoToEntity(PublicacionDTO publicacionDTO) {
        Publicacion publicacion = new Publicacion();
        publicacion.setBiografia(publicacionDTO.getBiografia());
        publicacion.setImagen(publicacionDTO.getImagen());
        publicacion.setDestacado(publicacionDTO.isDestacado());
        return publicacion;
    }

    public PublicacionDTO entityToDto(Publicacion saved) {
        PublicacionDTO  publicacionDTO = new PublicacionDTO();
        publicacionDTO.setId(saved.getId());
        publicacionDTO.setBiografia(saved.getBiografia());
        publicacionDTO.setImagen(saved.getImagen());
        publicacionDTO.setDestacado(saved.isDestacado());
        publicacionDTO.setFechaCreacion(saved.getFechaCreacion());
        return publicacionDTO;
    }

    public Publicacion updateEntity(Long id, PublicacionDTO publicacionDTO) {
        Optional<Publicacion> publicacion = publicacionRepository.findById(id);
        if(!publicacion.isPresent()){
            throw new NotFoundException("No existe la publicacion: " + id);
        }
        publicacion.get().setBiografia(publicacionDTO.getBiografia());
        publicacion.get().setImagen(publicacionDTO.getImagen());
        publicacion.get().setDestacado(publicacionDTO.isDestacado());
        return publicacion.get();
    }

    public List<PublicacionDTO> listEntityDto(List<Publicacion> listPublicacion) {
       return  listPublicacion.stream().map(p -> entityToDto(p)).collect(Collectors.toList());
    }

    public List<PublicacionDTO> listEntityDtoDestacado(List<Publicacion> listPublicacion) {
        return  listPublicacion.stream().map(p -> entityToDto(p)).filter(a->a.isDestacado() == true).collect(Collectors.toList());
    }

}
