package dev.anderk222.logs_app.comunicacion.platform;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import dev.anderk222.logs_app.comunicacion.GraphqlConsumer;
import dev.anderk222.logs_app.comunicacion.platform.dto.RequestPlatform;

@Component
public class GraphqlPlatformConsumer implements PlatformConsumer {

    private final GraphqlConsumer consumer;

    public GraphqlPlatformConsumer(GraphqlConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public <T, R> R process(RequestPlatform<T> request) throws IOException {

        ResponseEntity<R> response = this.consumer.process(request.getBody());

        if(response.getBody() != request.getSuccessStatus()){

            throw new IOException("Error al realizar la peticion");

        }

        return response.getBody();
    }
    
}