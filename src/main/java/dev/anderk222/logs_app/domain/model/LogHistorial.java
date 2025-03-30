package dev.anderk222.logs_app.domain.model;

import lombok.Data;

@Data
public class LogHistorial {
    
    private Long id;
    private String description;
    Log log; 
    Boolean status;

} 