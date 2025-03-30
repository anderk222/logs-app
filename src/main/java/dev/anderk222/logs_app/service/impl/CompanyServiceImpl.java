package dev.anderk222.logs_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.anderk222.logs_app.domain.entity.Company;
import dev.anderk222.logs_app.domain.repository.CompanyRepository;
import dev.anderk222.logs_app.service.contract.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    public List<Company> match(Company company, Pageable pageable){

        return companyRepository.findAll(Example.of(company), pageable).getContent();
    }

    public List<Company> search(Company company, Pageable pageable){

        ExampleMatcher matcher = ExampleMatcher.matching()
        .withIgnoreNullValues()
        .withMatcher("name", (m)->m.ignoreCase().contains())
        .withMatcher("description", (m)->m.ignoreCase().contains());

        return companyRepository.findAll(Example.of(company, matcher), pageable).getContent();
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }
}
