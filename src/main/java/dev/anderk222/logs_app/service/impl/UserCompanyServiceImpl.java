package dev.anderk222.logs_app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.anderk222.logs_app.domain.entity.UserCompany;
import dev.anderk222.logs_app.domain.repository.UserCompanyRepository;
import dev.anderk222.logs_app.service.contract.UserCompanyService;

@Service
public class UserCompanyServiceImpl implements UserCompanyService {
    @Autowired
    private UserCompanyRepository userCompanyRepository;

    public List<UserCompany> findAll() {
        return userCompanyRepository.findAll();
    }

    public Optional<UserCompany> findById(Long id) {
        return userCompanyRepository.findById(id);
    }

    public UserCompany save(UserCompany userCompany) {
        return userCompanyRepository.save(userCompany);
    }

    public void deleteById(Long id) {
        userCompanyRepository.deleteById(id);
    }

    @Override
    public List<UserCompany> match(UserCompany catalogue, Pageable pageable) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'match'");
    }
}
