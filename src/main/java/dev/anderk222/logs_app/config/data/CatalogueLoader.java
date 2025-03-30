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
import dev.anderk222.logs_app.domain.entity.Catalogue;
import dev.anderk222.logs_app.domain.repository.CatalogueRepository;

@Component
@Order(1)
public class CatalogueLoader implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(CatalogueLoader.class);
    private final CatalogueRepository catalogueRepository;
    private final ObjectMapper mapper;

    public CatalogueLoader(CatalogueRepository catalogueRepository, ObjectMapper mapper) {
        this.catalogueRepository = catalogueRepository;
        this.mapper = mapper;
    }

    @Override
    public void run(String... args) throws Exception {

        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/catalogues.json")) {

            log.info("Cargando catalogos por default");
            if (this.catalogueRepository.count() == 0) {

                List<Catalogue> catalogues = this.mapper.readValue(inputStream,
                        new com.fasterxml.jackson.core.type.TypeReference<List<Catalogue>>() {
                        });

                this.catalogueRepository.saveAll(catalogues);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
