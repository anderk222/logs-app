package dev.anderk222.logs_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.anderk222.logs_app.domain.entity.Endpoint;
import dev.anderk222.logs_app.domain.repository.EndpointRepository;
import dev.anderk222.logs_app.service.contract.EndpointService;

@Service
public class EndpointServiceImpl implements EndpointService {
    @Autowired
    private EndpointRepository endpointRepository;

    public List<Endpoint> findAll() {
        return endpointRepository.findAll();
    }

    public Optional<Endpoint> findById(Long id) {
        return endpointRepository.findById(id);
    }

    public List<Endpoint> match(Endpoint endpoint, Pageable pageable){

        return endpointRepository.findAll(Example.of(endpoint), pageable).getContent();
    }

    public List<Endpoint> search(Endpoint endpoint, Pageable pageable){

        ExampleMatcher matcher = ExampleMatcher.matching()
        .withIgnoreNullValues()
        .withMatcher("name", (m)->m.ignoreCase().contains())
        .withMatcher("description", (m)->m.ignoreCase().contains())
        .withMatcher("path", (m)->m.ignoreCase().contains())
        .withMatcher("type", (m)->m.ignoreCase().contains());

        return endpointRepository.findAll(Example.of(endpoint, matcher), pageable).getContent();
    }

    public Endpoint save(Endpoint endpoint) {
        return endpointRepository.save(endpoint);
    }

    public void deleteById(Long id) {
        endpointRepository.deleteById(id);
    }
}

