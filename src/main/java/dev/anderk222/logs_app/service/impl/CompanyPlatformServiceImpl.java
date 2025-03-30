package dev.anderk222.logs_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.anderk222.logs_app.domain.entity.CompanyPlatform;
import dev.anderk222.logs_app.domain.repository.CompanyPlatformRepository;
import dev.anderk222.logs_app.service.contract.CompanyPlatformService;

@Service
public class CompanyPlatformServiceImpl implements CompanyPlatformService {
    @Autowired
    private CompanyPlatformRepository companyPlatformRepository;

    public List<CompanyPlatform> findAll() {
        return companyPlatformRepository.findAll();
    }

    public Optional<CompanyPlatform> findById(Long id) {
        return companyPlatformRepository.findById(id);
    }

    public CompanyPlatform save(CompanyPlatform companyPlatform) {
        return companyPlatformRepository.save(companyPlatform);
    }

    public void deleteById(Long id) {
        companyPlatformRepository.deleteById(id);
    }

    @Override
    public List<CompanyPlatform> match(CompanyPlatform catalogue, Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'match'");
    }
}
