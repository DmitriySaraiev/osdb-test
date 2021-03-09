package com.saraiev.osdbtest.service;

import com.saraiev.osdbtest.api.request.BaseCompanyRequest;
import com.saraiev.osdbtest.api.request.CreateCompanyRequest;
import com.saraiev.osdbtest.api.request.UpdateCompanyRequest;
import com.saraiev.osdbtest.domain.Company;
import com.saraiev.osdbtest.repo.CompanyRepository;
import com.saraiev.osdbtest.util.PageableBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public ResponseEntity<Company> get(Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        return optionalCompany
                .map(company -> new ResponseEntity<>(company, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Page<Company>> list(Integer page, Integer size, String[] sortFields) {
        Pageable pageable = PageableBuilder.build(page,size,sortFields);
        return new ResponseEntity<>(companyRepository.findAll(pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Company> create(CreateCompanyRequest request) {
        Company companyFromRequest = buildFromRequest(request);
        Company savedCompany = companyRepository.save(companyFromRequest);
        return new ResponseEntity<>(savedCompany, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Company> update(UpdateCompanyRequest request) {
        Optional<Company> optionalCompany = companyRepository.findById(request.getId());
        if(optionalCompany.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Company company = buildFromRequest(request);
        company.setId(request.getId());
        company = companyRepository.save(company);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        companyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Company buildFromRequest(BaseCompanyRequest request) {
        Company company = new Company();
        company.setTitle(request.getTitle());
        company.setFounded(request.getFounded());
        return company;
    }

}
