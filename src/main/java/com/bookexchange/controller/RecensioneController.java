package com.bookexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bookexchange.model.Recensione;
import com.bookexchange.service.RecensioneService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recensioni")
public class RecensioneController {

    @Autowired
    private RecensioneService recensioneService;

    @GetMapping
    public List<Recensione> getAllRecensioni() {
        return recensioneService.getAllRecensioni();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recensione> getRecensioneById(@PathVariable Long id) {
        Optional<Recensione> recensione = recensioneService.getRecensioneById(id);
        return recensione.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Recensione createRecensione(@RequestBody Recensione recensione) {
        return recensioneService.saveRecensione(recensione);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecensione(@PathVariable Long id) {
        recensioneService.deleteRecensione(id);
        return ResponseEntity.noContent().build();
    }
}
