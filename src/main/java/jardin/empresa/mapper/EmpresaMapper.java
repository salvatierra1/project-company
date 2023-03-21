package jardin.empresa.mapper;

import jardin.empresa.DTO.EmpresaDTO;
import jardin.empresa.exception.NotFoundException;
import jardin.empresa.model.Empresa;
import jardin.empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EmpresaMapper {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa dtoToEntity(EmpresaDTO empresaDTO) {
        Empresa empresa = new Empresa();
        empresa.setName(empresaDTO.getName());
        empresa.setBiografia(empresaDTO.getBiografia());
        empresa.setResolucion(empresaDTO.getResolucion());
        empresa.setUbicacion(empresaDTO.getUbicacion());
        empresa.setHorarios(empresaDTO.getHorarios());
        empresa.setTelefono(empresaDTO.getTelefono());
        empresa.setEmail(empresaDTO.getEmail());
        empresa.setImagen(empresaDTO.getImagen());
        empresa.setLinkIg(empresaDTO.getLinkIg());
        empresa.setLinkFb(empresaDTO.getLinkFb());
        empresa.setLinkLk(empresaDTO.getLinkLk());
        empresa.setMision(empresaDTO.getMision());
        empresa.setVision(empresaDTO.getVision());
        return empresa;
    }
    public EmpresaDTO entityToDto(Empresa saved) {
        EmpresaDTO dto = new EmpresaDTO();
        dto.setId(saved.getId());
        dto.setName(saved.getName());
        dto.setBiografia(saved.getBiografia());
        dto.setResolucion(saved.getResolucion());
        dto.setUbicacion(saved.getUbicacion());
        dto.setHorarios(saved.getHorarios());
        dto.setTelefono(saved.getTelefono());
        dto.setEmail(saved.getEmail());
        dto.setImagen(saved.getImagen());
        dto.setLinkIg(saved.getLinkIg());
        dto.setLinkFb(saved.getLinkFb());
        dto.setLinkLk(saved.getLinkLk());
        dto.setMision(saved.getMision());
        dto.setVision(saved.getVision());
        return dto;
    }

    public Empresa updateEntity(Long id, EmpresaDTO empresaDTO) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if(!empresa.isPresent()){
            throw new NotFoundException("No existe la empresa: " + id);
        }
        empresa.get().setName(empresaDTO.getName());
        empresa.get().setBiografia(empresaDTO.getBiografia());
        empresa.get().setResolucion(empresaDTO.getResolucion());
        empresa.get().setUbicacion(empresaDTO.getUbicacion());
        empresa.get().setHorarios(empresaDTO.getHorarios());
        empresa.get().setTelefono(empresaDTO.getTelefono());
        empresa.get().setEmail(empresaDTO.getEmail());
        empresa.get().setImagen(empresaDTO.getImagen());
        empresa.get().setLinkIg(empresaDTO.getLinkIg());
        empresa.get().setLinkFb(empresaDTO.getLinkFb());
        empresa.get().setLinkLk(empresaDTO.getLinkLk());
        empresa.get().setMision(empresaDTO.getMision());
        empresa.get().setVision(empresaDTO.getVision());
        return empresa.get();
    }

    public List<EmpresaDTO> listEntityDto(List<Empresa> listEmpresa) {
        return  listEmpresa.stream().map(p -> entityToDto(p)).collect(Collectors.toList());

    }
}
