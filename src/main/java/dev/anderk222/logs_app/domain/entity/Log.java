package dev.anderk222.logs_app.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Log")
@Data
@AllArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_id_seq")
    @SequenceGenerator(name = "log_id_seq", sequenceName = "log_id_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_company_id", nullable = false)
    private UserCompany userCompany;

    @ManyToOne
    @JoinColumn(name = "company_platform_id", nullable = false)
    private CompanyPlatform companyPlatform;

    @Column(nullable = false)
    private Boolean status;
}