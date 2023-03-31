package jardin.empresa.service.impl;

import jardin.empresa.DTO.CompanyDTO;
import jardin.empresa.mapper.CompanyMapper;
import jardin.empresa.model.Company;
import jardin.empresa.repository.CompanyRepository;
import jardin.empresa.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public CompanyDTO save(CompanyDTO companyDTO) {
        Company company = companyMapper.dtoToEntity(companyDTO);
        Company saved = companyRepository.save(company);
        return companyMapper.entityToDto(saved);
    }
    @Override
    public CompanyDTO get(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        return companyMapper.entityToDto(company);
    }
    @Override
    public void delete(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        companyRepository.delete(company);
    }
    @Override
    public CompanyDTO put(Long id, CompanyDTO companyDTO) {
        Company company = companyMapper.updateEntity(id, companyDTO);
        Company saved = companyRepository.save(company);
        return companyMapper.entityToDto(saved);
    }

    @Override
    public List<CompanyDTO> getList() {
        List<Company> list = companyRepository.findAll();
        return companyMapper.listEntityDto(list);
    }
}
