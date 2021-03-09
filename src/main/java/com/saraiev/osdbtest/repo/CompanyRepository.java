package com.saraiev.osdbtest.repo;

import com.saraiev.osdbtest.domain.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

    Page<Company> findAll(Pageable pageable);

}
