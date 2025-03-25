package com.bookexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bookexchange.model.Interesse;
import com.bookexchange.service.InteresseService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/interessi")
public class InteresseController {

    @Autowired
    private InteresseService interesseService;

    @GetMapping
    public List<Interesse> getAllInteressi() {
        return interesseService.getAllInteressi();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Interesse> getInteresseById(@PathVariable Long id) {
        Optional<Interesse> interesse = interesseService.getInteresseById(id);
        return interesse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Interesse createInteresse(@RequestBody Interesse interesse) {
        return interesseService.saveInteresse(interesse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInteresse(@PathVariable Long id) {
        interesseService.deleteInteresse(id);
        return ResponseEntity.noContent().build();
    }
}

