package dev.anderk222.logs_app.comunicacion;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GraphqlConsumer implements GenericConsumer {

    public final RestTemplate restTemplate;

    public GraphqlConsumer(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T, R> ResponseEntity<R> process(RequestEntity<T> request) {

        return this.restTemplate.exchange(request, new ParameterizedTypeReference<R>(){});
    }
}