package jardin.empresa.service.impl;

import jardin.empresa.DTO.EmpleadoDTO;
import jardin.empresa.mapper.EmpleadoMapper;
import jardin.empresa.model.Empleado;
import jardin.empresa.repository.EmpleadoRepository;
import jardin.empresa.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private EmpleadoMapper empleadoMapper;

    @Override
    public EmpleadoDTO save(EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoMapper.dtoToEntity(empleadoDTO);
        Empleado saved = empleadoRepository.save(empleado);
        EmpleadoDTO dto = empleadoMapper.entityToDto(saved);
        return dto;
    }

    @Override
    public EmpleadoDTO get(Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        EmpleadoDTO dto = empleadoMapper.entityToDto(empleado.get());
        return dto;
    }
    @Override
    public void delete(Long id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public EmpleadoDTO put(Long id, EmpleadoDTO empleadoDTO) {
        Empleado empleado = empleadoMapper.updateEntity(id, empleadoDTO);
        Empleado saved = empleadoRepository.save(empleado);
        EmpleadoDTO dto = empleadoMapper.entityToDto(saved);
        return dto;
    }

}
