package jardin.empresa.service;

import jardin.empresa.DTO.CompanyDTO;

import java.util.List;

public interface CompanyService {
    CompanyDTO save(CompanyDTO companyDTO);
    CompanyDTO get(Long id);
    void delete(Long id);
    CompanyDTO put(Long id, CompanyDTO companyDTO);
    List<CompanyDTO> getList();
}
