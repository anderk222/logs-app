package dev.anderk222.logs_app.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public record PlatformAuthCompany(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "platformauthcompany_id_seq")
        @SequenceGenerator(name = "platformauthcompany_id_seq", sequenceName = "platformauthcompany_id_seq", allocationSize = 1)
        Long id,
        @ManyToOne
        @JoinColumn(name = "platform_id")
        Platform platform,
        @ManyToOne
        @JoinColumn(name = "company_id")
        Company company,
        String type,
        String name,
        String status
) {}