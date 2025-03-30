package dev.anderk222.logs_app.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public record PlatformEndpoint(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "platformendpoint_id_seq")
        @SequenceGenerator(name = "platformendpoint_id_seq", sequenceName = "platformendpoint_id_seq", allocationSize = 1)
        Long id,
        @ManyToOne
        @JoinColumn(name = "platform_id")
        Platform platform,
        @ManyToOne
        @JoinColumn(name = "endpoint_id")
        Endpoint endpoint,
        @ManyToOne
        @JoinColumn(name = "method_id")
        Catalogue method,
        @ManyToOne
        @JoinColumn(name = "success_code_id")
        Catalogue successCode
){}