package dev.anderk222.logs_app.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.anderk222.logs_app.domain.entity.UserCompany;

public interface UserCompanyRepository extends JpaRepository<UserCompany, Long>{}
