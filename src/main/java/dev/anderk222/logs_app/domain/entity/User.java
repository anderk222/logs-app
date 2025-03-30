package dev.anderk222.logs_app.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity(name = "UserApp")
public record User(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
        @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
        Long id,
        String username,
        String email,
        String name,
        String lastname,
        String status
) {}
