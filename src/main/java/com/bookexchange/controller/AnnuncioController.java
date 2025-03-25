package com.bookexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bookexchange.model.Annuncio;
import com.bookexchange.service.AnnuncioService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/annunci")
public class AnnuncioController {

    @Autowired
    private AnnuncioService annuncioService;

    @GetMapping
    public List<Annuncio> getAllAnnunci() {
        return annuncioService.getAllAnnunci();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Annuncio> getAnnuncioById(@PathVariable Long id) {
        Optional<Annuncio> annuncio = annuncioService.getAnnuncioById(id);
        return annuncio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Annuncio createAnnuncio(@RequestBody Annuncio annuncio) {
        return annuncioService.saveAnnuncio(annuncio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnuncio(@PathVariable Long id) {
        annuncioService.deleteAnnuncio(id);
        return ResponseEntity.noContent().build();
    }
}
