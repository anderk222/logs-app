package dev.anderk222.logs_app.comunicacion;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public interface GenericConsumer {

    public <T,R> ResponseEntity<R> process(RequestEntity<T> request);    
}
