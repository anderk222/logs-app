
package dev.anderk222.logs_app.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Catalogue{
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogue_id_seq")
        @SequenceGenerator(name = "catalogue_id_seq", sequenceName = "catalogue_id_seq", allocationSize = 1)
        private Long id;
        private String codigo;
        private String value;
        private String description;
}