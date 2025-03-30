package dev.anderk222.logs_app.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Platform{
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "platform_id_seq")
        @SequenceGenerator(name = "platform_id_seq", sequenceName = "platform_id_seq", allocationSize = 1)
        private Long id;
        private String name;
        private String description;
        private String status;
}