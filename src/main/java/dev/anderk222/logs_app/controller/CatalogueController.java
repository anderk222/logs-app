package dev.anderk222.logs_app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.anderk222.logs_app.domain.entity.Catalogue;
import dev.anderk222.logs_app.service.impl.CatalogueServiceImpl;

@RestController
@RequestMapping("/api/catalogues") 
public class CatalogueController {

    @Autowired
    private CatalogueServiceImpl catalogueService;

    @GetMapping
    public List<Catalogue> getAllCatalogues() {
        return catalogueService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalogue> getCatalogueById(@PathVariable Long id) {
        Optional<Catalogue> catalogue = catalogueService.findById(id);
        return catalogue.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Catalogue createCatalogue(@RequestBody Catalogue catalogue) {
        return catalogueService.save(catalogue);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Catalogue> updateCatalogue(@PathVariable Long id, @RequestBody Catalogue updatedCatalogue) {
        return catalogueService.findById(id)
                .map(catalogue -> {
                    Catalogue newCatalogue = new Catalogue(id, updatedCatalogue.getCodigo(), updatedCatalogue.getValue(), updatedCatalogue.getDescription());
                    catalogueService.save(newCatalogue);
                    return ResponseEntity.ok(newCatalogue);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatalogue(@PathVariable Long id) {
        if (catalogueService.findById(id).isPresent()) {
            catalogueService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/match")
    public List<Catalogue> match(@RequestBody Catalogue catalogue,
    @PageableDefault(page = 0, size = 20, direction = Direction.DESC, sort = { "id" }) Pageable pageable){

        return catalogueService.match(catalogue, pageable);

    }

    @PostMapping("/search")
    public List<Catalogue> search(@RequestBody Catalogue catalogue,
    @PageableDefault(page = 0, size = 20, direction = Direction.DESC, sort = { "id" }) Pageable pageable){

        return catalogueService.search(catalogue, pageable);

    }
}