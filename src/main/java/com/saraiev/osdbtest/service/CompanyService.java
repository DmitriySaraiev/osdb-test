package com.saraiev.osdbtest.service;

import com.saraiev.osdbtest.api.request.CreateCompanyRequest;
import com.saraiev.osdbtest.api.request.UpdateCompanyRequest;
import com.saraiev.osdbtest.domain.Company;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface CompanyService {

    ResponseEntity<Company> get(Long id);

    ResponseEntity<Page<Company>> list(Integer page, Integer size, String[] sortFields);

    ResponseEntity<Company> create(CreateCompanyRequest request);

    ResponseEntity<Company> update(UpdateCompanyRequest request);

    ResponseEntity delete(Long id);

}
