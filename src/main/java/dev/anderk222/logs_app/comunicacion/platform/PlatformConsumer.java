package dev.anderk222.logs_app.comunicacion.platform;

import java.io.IOException;

import dev.anderk222.logs_app.comunicacion.platform.dto.RequestPlatform;

public interface PlatformConsumer {

    public <T,R> R process(RequestPlatform<T> request) throws IOException;
    
}