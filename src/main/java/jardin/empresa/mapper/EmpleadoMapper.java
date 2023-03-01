package jardin.empresa.mapper;

import jardin.empresa.DTO.EmpleadoDTO;
import jardin.empresa.model.Empleado;
import jardin.empresa.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    public Empleado dtoToEntity(EmpleadoDTO empleadoDTO) {
        Empleado empleado = new Empleado();
        empleado.setName(empleadoDTO.getName());
        empleado.setApellido(empleadoDTO.getApellido());
        empleado.setTitulo(empleadoDTO.getTitulo());
        empleado.setBiografia(empleadoDTO.getBiografia());
        empleado.setImagen(empleadoDTO.getImagen());
        return empleado;
    }

    public EmpleadoDTO entityToDto(Empleado saved) {
        EmpleadoDTO empleadoDTO = new EmpleadoDTO();
        empleadoDTO.setId(saved.getId());
        empleadoDTO.setName(saved.getName());
        empleadoDTO.setApellido(saved.getApellido());
        empleadoDTO.setTitulo(saved.getTitulo());
        empleadoDTO.setBiografia(saved.getBiografia());
        empleadoDTO.setImagen(saved.getImagen());
        return empleadoDTO;
    }

    public Empleado updateEntity(Long id, EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoRepository.findById(id).get();
        empleado.setName(empleadoDTO.getName());
        empleado.setName(empleadoDTO.getName());
        empleado.setApellido(empleadoDTO.getApellido());
        empleado.setTitulo(empleadoDTO.getTitulo());
        empleado.setBiografia(empleadoDTO.getBiografia());
        empleado.setImagen(empleadoDTO.getImagen());
        return empleado;
    }
}
