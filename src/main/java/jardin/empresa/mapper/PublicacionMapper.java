package jardin.empresa.mapper;

import jardin.empresa.DTO.PublicacionDTO;
import jardin.empresa.model.Publicacion;
import jardin.empresa.repository.PublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublicacionMapper {


    @Autowired
    private PublicacionRepository publicacionRepository;

    public Publicacion dtoToEntity(PublicacionDTO publicacionDTO) {
        Publicacion publicacion = new Publicacion();
        publicacion.setName(publicacionDTO.getName());
        publicacion.setBiografia(publicacionDTO.getBiografia());
        publicacion.setFecha(publicacionDTO.getFecha());
        publicacion.setImagen(publicacionDTO.getImagen());
        return publicacion;
    }

    public PublicacionDTO entityToDto(Publicacion saved) {
        PublicacionDTO  publicacionDTO = new PublicacionDTO();
        publicacionDTO.setId(saved.getId());
        publicacionDTO.setName(saved.getName());
        publicacionDTO.setBiografia(saved.getBiografia());
        publicacionDTO.setFecha(saved.getFecha());
        publicacionDTO.setImagen(saved.getImagen());
        return publicacionDTO;
    }

    public Publicacion updateEntity(Long id, PublicacionDTO publicacionDTO) {
        Publicacion publicacion = publicacionRepository.findById(id).get();
        publicacion.setName(publicacionDTO.getName());
        publicacion.setBiografia(publicacionDTO.getBiografia());
        publicacion.setFecha(publicacionDTO.getFecha());
        publicacion.setImagen(publicacionDTO.getImagen());
        return publicacion;
    }
}
