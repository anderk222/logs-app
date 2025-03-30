package dev.anderk222.logs_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.anderk222.logs_app.domain.entity.Platform;
import dev.anderk222.logs_app.domain.repository.PlatformRepository;
import dev.anderk222.logs_app.service.contract.PlatformService;

@Service
public class PlatformServiceImpl implements PlatformService {
    @Autowired
    private PlatformRepository platformRepository;

    public List<Platform> findAll() {
        return platformRepository.findAll();
    }

    public Optional<Platform> findById(Long id) {
        return platformRepository.findById(id);
    }

    public List<Platform> match(Platform platform, Pageable pageable){

        return platformRepository.findAll(Example.of(platform), pageable).getContent();
    }

    public List<Platform> search(Platform platform, Pageable pageable){

        ExampleMatcher matcher = ExampleMatcher.matching()
        .withIgnoreNullValues()
        .withMatcher("name", (m)->m.ignoreCase().contains())
        .withMatcher("description", (m)->m.ignoreCase().contains());

        return platformRepository.findAll(Example.of(platform, matcher), pageable).getContent();
    }

    public Platform save(Platform platform) {
        return platformRepository.save(platform);
    }

    public void deleteById(Long id) {
        platformRepository.deleteById(id);
    }
}
