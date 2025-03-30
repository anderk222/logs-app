package dev.anderk222.logs_app.comunicacion.platform.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestPlatform<T> {

    private String platform;

    private RequestEntity<T> body;

    private TypeReqEnum type;

    private HttpStatus successStatus = HttpStatus.OK;

    private Long companyCod;
    
}