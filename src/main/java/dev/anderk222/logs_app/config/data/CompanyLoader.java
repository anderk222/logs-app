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
import dev.anderk222.logs_app.domain.entity.Company;
import dev.anderk222.logs_app.domain.repository.CompanyRepository;

@Component
@Order(1)
public class CompanyLoader implements CommandLineRunner {

        private final Logger log = LoggerFactory.getLogger(CatalogueLoader.class);
    private final CompanyRepository company;
    private final ObjectMapper mapper;

    public CompanyLoader(CompanyRepository company, ObjectMapper mapper) {
        this.company = company;
        this.mapper = mapper;
    }

    @Override
    public void run(String... args) throws Exception {

        try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/companies.json")) {

            log.info("Cargando comapias por default");
            if (this.company.count() == 0) {

                List<Company> companies = this.mapper.readValue(inputStream,
                        new com.fasterxml.jackson.core.type.TypeReference<List<Company>>() {
                        });

                this.company.saveAll(companies);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
