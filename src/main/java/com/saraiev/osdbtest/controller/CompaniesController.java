package com.saraiev.osdbtest.controller;

import com.saraiev.osdbtest.api.request.CreateCompanyRequest;
import com.saraiev.osdbtest.api.request.UpdateCompanyRequest;
import com.saraiev.osdbtest.domain.Company;
import com.saraiev.osdbtest.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/companies")
@RequiredArgsConstructor
public class CompaniesController {

    private final CompanyService companyService;

    @Operation(summary = "Get company by ist id")
    @GetMapping("/{id}")
    public ResponseEntity<Company> get(@PathVariable Long id) {
        return companyService.get(id);
    }

    @Operation(summary = "Get paginated company list")
    @GetMapping
    public ResponseEntity<Page<Company>> get(@RequestParam(value = "page", required = false) Integer page,
                                             @RequestParam(value = "size", required = false) Integer size,
                                             @RequestParam(value = "sort", required = false) String[] sort) {
        return companyService.list(page, size, sort);
    }

    @Operation(summary = "Create new company")
    @PostMapping
    public ResponseEntity<Company> create(CreateCompanyRequest request) {
        return companyService.create(request);
    }

    @Operation(summary = "Update existing company information")
    @PutMapping
    public ResponseEntity<Company> update(UpdateCompanyRequest request) {
        return companyService.update(request);
    }

    @Operation(summary = "Delete existing company")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        return companyService.delete(id);
    }

}
