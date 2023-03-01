package jardin.empresa.mapper;

import jardin.empresa.DTO.EmpresaDTO;
import jardin.empresa.model.Empresa;
import jardin.empresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        empresa.setImagen(empresaDTO.getImagen());
        empresa.setLinkRedes(empresaDTO.getLinkRedes());
        empresa.setLogoRedes(empresa.getLogoRedes());
        return empresa;
    }
    public EmpresaDTO entityToDto(Empresa saved) {
        EmpresaDTO dto = new EmpresaDTO();
        dto.setId(saved.getId());
        dto.setName(saved.getName());
        dto.setBiografia(saved.getBiografia());
        dto.setResolucion(saved.getResolucion());
        dto.setUbicacion(saved.getUbicacion());
        dto.setImagen(saved.getImagen());
        dto.setLinkRedes(saved.getLinkRedes());
        dto.setLogoRedes(saved.getLogoRedes());
        return dto;
    }

    public Empresa updateEntity(Long id, EmpresaDTO empresaDTO) {
        Empresa empresa = empresaRepository.findById(id).get();
        empresa.setName(empresaDTO.getName());
        empresa.setBiografia(empresaDTO.getBiografia());
        empresa.setResolucion(empresaDTO.getResolucion());
        empresa.setUbicacion(empresaDTO.getUbicacion());
        empresa.setImagen(empresaDTO.getImagen());
        empresa.setLinkRedes(empresaDTO.getLinkRedes());
        empresa.setLogoRedes(empresa.getLogoRedes());
        return empresa;
    }

}
