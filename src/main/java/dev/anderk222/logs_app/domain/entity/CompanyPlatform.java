package dev.anderk222.logs_app.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;


@Entity
public record CompanyPlatform(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "companyplatform_id_seq")
        @SequenceGenerator(name = "companyplatform_id_seq", sequenceName = "companyplatform_id_seq", allocationSize = 1)
        Long id,
        @ManyToOne
        @JoinColumn(name = "company_id")
        Company company,
        @ManyToOne
        @JoinColumn(name = "platform_id")
        Platform platform,
        String httpAddress
) {}