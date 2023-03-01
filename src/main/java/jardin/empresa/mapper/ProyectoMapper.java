package jardin.empresa.mapper;

import jardin.empresa.DTO.ProyectoDTO;
import jardin.empresa.model.Proyecto;
import jardin.empresa.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProyectoMapper {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public Proyecto dtoToEntity(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = new Proyecto();
        proyecto.setName(proyectoDTO.getName());
        proyecto.setBiografia(proyectoDTO.getBiografia());
        proyecto.setImagen(proyectoDTO.getImagen());
        return proyecto;
    }

    public ProyectoDTO entityToDto(Proyecto saved) {
        ProyectoDTO proyectoDTO = new ProyectoDTO();
        proyectoDTO.setId(saved.getId());
        proyectoDTO.setName(saved.getName());
        proyectoDTO.setBiografia(saved.getBiografia());
        proyectoDTO.setImagen(saved.getImagen());
        return proyectoDTO;
    }

    public Proyecto updateEntity(Long id, ProyectoDTO proyectoDTO) {
        Proyecto proyecto = proyectoRepository.findById(id).get();
        proyecto.setName(proyectoDTO.getName());
        proyecto.setBiografia(proyectoDTO.getBiografia());
        proyecto.setImagen(proyectoDTO.getImagen());
        return proyecto;
    }
}
