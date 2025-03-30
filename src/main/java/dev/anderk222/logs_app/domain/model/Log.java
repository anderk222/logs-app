package dev.anderk222.logs_app.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Log {

    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String description;
    private UserCompany userCompany;
    private CompanyPlatform companyPlatform;
    private Boolean status;
}