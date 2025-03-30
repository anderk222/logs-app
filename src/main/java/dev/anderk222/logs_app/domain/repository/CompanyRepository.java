package dev.anderk222.logs_app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.anderk222.logs_app.domain.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {}

