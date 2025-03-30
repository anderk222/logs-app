package dev.anderk222.logs_app.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public record Endpoint(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endpoint_id_seq")
        @SequenceGenerator(name = "endpoint_id_seq", sequenceName = "endpoint_id_seq", allocationSize = 1)
        Long id,
        String name,
        String description,
        String path,
        String type
) {}