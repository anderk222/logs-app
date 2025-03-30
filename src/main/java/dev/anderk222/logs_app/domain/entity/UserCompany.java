package dev.anderk222.logs_app.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public record UserCompany(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usercompany_id_seq")
        @SequenceGenerator(name = "usercompany_id_seq", sequenceName = "usercompany_id_seq", allocationSize = 1)
        Long id,
        @ManyToOne
        @JoinColumn(name = "user_id")
        User user,
        @ManyToOne
        @JoinColumn(name = "company_id")
        Company company,
        String status
) {}