package dev.anderk222.logs_app.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.anderk222.logs_app.domain.entity.Catalogue;
import dev.anderk222.logs_app.domain.repository.CatalogueRepository;
import dev.anderk222.logs_app.service.contract.CatalogueService;

@Service
public class CatalogueServiceImpl implements CatalogueService {
    
    @Autowired
    private CatalogueRepository catalogueRepository;

    public List<Catalogue> findAll() {
        return catalogueRepository.findAll();
    }

    public Optional<Catalogue> findById(Long id) {
        return catalogueRepository.findById(id);
    }

    public List<Catalogue> match(Catalogue catalogue, Pageable pageable){

        return catalogueRepository.findAll(Example.of(catalogue), pageable).getContent();

    }

    public List<Catalogue> search(Catalogue catalogue, Pageable pageable){

        ExampleMatcher matcher = ExampleMatcher.matching()
        .withIgnoreNullValues()
        .withMatcher("value", (m)->m.ignoreCase().contains());

        return catalogueRepository.findAll(Example.of(catalogue, matcher), pageable).getContent();

    }

    public Catalogue save(Catalogue catalogue) {
        return catalogueRepository.save(catalogue);
    }

    public void deleteById(Long id) {
        catalogueRepository.deleteById(id);
    }
}
