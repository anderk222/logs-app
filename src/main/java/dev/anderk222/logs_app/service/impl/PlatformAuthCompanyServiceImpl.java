package dev.anderk222.logs_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.anderk222.logs_app.domain.entity.PlatformAuthCompany;
import dev.anderk222.logs_app.domain.repository.PlatformAuthCompanyRepository;
import dev.anderk222.logs_app.service.contract.PlatformAuthCompanyService;

@Service
public class PlatformAuthCompanyServiceImpl implements PlatformAuthCompanyService {
    @Autowired
    private PlatformAuthCompanyRepository platformAuthCompanyRepository;

    public List<PlatformAuthCompany> findAll() {
        return platformAuthCompanyRepository.findAll();
    }

    public Optional<PlatformAuthCompany> findById(Long id) {
        return platformAuthCompanyRepository.findById(id);
    }

    public PlatformAuthCompany save(PlatformAuthCompany platformAuthCompany) {
        return platformAuthCompanyRepository.save(platformAuthCompany);
    }

    public void deleteById(Long id) {
        platformAuthCompanyRepository.deleteById(id);
    }

    @Override
    public List<PlatformAuthCompany> match(PlatformAuthCompany catalogue, Pageable pageable) {
        throw new UnsupportedOperationException("Unimplemented method 'match'");
    }
}
