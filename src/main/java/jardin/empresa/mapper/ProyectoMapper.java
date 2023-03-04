package jardin.empresa.mapper;

import jardin.empresa.DTO.ProyectoDTO;
import jardin.empresa.exception.NotFoundException;
import jardin.empresa.model.Proyecto;
import jardin.empresa.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
public class ProyectoMapper {

    @Autowired
    private ProyectoRepository proyectoRepository;

    public Proyecto dtoToEntity(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = new Proyecto();
        proyecto.setName(proyectoDTO.getName());
        proyecto.setBiografia(proyectoDTO.getBiografia());
        proyecto.setImagen(proyectoDTO.getImagen());
        proyecto.setMision(proyectoDTO.getMision());
        proyecto.setVision(proyectoDTO.getVision());
        return proyecto;
    }

    public ProyectoDTO entityToDto(Proyecto saved) {
        ProyectoDTO proyectoDTO = new ProyectoDTO();
        proyectoDTO.setId(saved.getId());
        proyectoDTO.setName(saved.getName());
        proyectoDTO.setBiografia(saved.getBiografia());
        proyectoDTO.setImagen(saved.getImagen());
        proyectoDTO.setMision(saved.getMision());
        proyectoDTO.setVision(saved.getVision());
        return proyectoDTO;
    }

    public Proyecto updateEntity(Long id, ProyectoDTO proyectoDTO) {
        Optional<Proyecto> proyecto = proyectoRepository.findById(id);
        if(!proyecto.isPresent()){
            throw new NotFoundException("No existe el proyecto: " + id);
        }
        proyecto.get().setName(proyectoDTO.getName());
        proyecto.get().setBiografia(proyectoDTO.getBiografia());
        proyecto.get().setImagen(proyectoDTO.getImagen());
        proyecto.get().setMision(proyectoDTO.getMision());
        proyecto.get().setVision(proyectoDTO.getVision());
        return proyecto.get();
    }

    public List<ProyectoDTO> listEntityDto(List<Proyecto> proyectos) {
        return proyectos.stream().map(p->entityToDto(p)).collect(Collectors.toList());
    }
}
