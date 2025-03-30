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
public class Company{
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_id_seq")
        @SequenceGenerator(name = "company_id_seq", sequenceName = "company_id_seq", allocationSize = 1)
        Long id;
        String name;
        String description;
        String status;
}