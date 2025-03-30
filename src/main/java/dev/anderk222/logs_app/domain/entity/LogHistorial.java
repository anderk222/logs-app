package dev.anderk222.logs_app.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class LogHistorial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_historial_id_seq")
    @SequenceGenerator(name = "log_historial_id_seq", sequenceName = "log_historial_id_seq", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "log_id")
    Log log; 

    @Column(nullable = false)
    Boolean status;

}