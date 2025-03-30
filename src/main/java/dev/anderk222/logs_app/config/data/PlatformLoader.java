package dev.anderk222.logs_app.config.data;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import aj.org.objectweb.asm.TypeReference;
import dev.anderk222.logs_app.domain.entity.Platform;
import dev.anderk222.logs_app.domain.repository.PlatformRepository;

@Component
@Order(1)
public class PlatformLoader implements CommandLineRunner {

    private final ObjectMapper mapper;
    private final PlatformRepository platformRepository;

    public PlatformLoader(ObjectMapper mapper, PlatformRepository platformRepository) {
        this.mapper = mapper;
        this.platformRepository = platformRepository;
    }

    private final Logger log = LoggerFactory.getLogger(Platform.class);

    @Override
    public void run(String... args) throws Exception {

        log.info("Cargando plataformas ");

        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/platform.json")) {

            List<Platform> platforms = this.mapper.readValue(inputStream,
                    new com.fasterxml.jackson.core.type.TypeReference<List<Platform>>() {
                    });

            this.platformRepository.saveAll(platforms);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
