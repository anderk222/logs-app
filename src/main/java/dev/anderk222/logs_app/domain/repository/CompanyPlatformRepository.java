package dev.anderk222.logs_app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.anderk222.logs_app.domain.entity.CompanyPlatform;

public interface CompanyPlatformRepository extends JpaRepository<CompanyPlatform, Long> {}
