package com.bookexchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bookexchange.model.Messaggio;
import com.bookexchange.service.MessaggioService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messaggi")
public class MessaggioController {

    @Autowired
    private MessaggioService messaggioService;

    @GetMapping
    public List<Messaggio> getAllMessaggi() {
        return messaggioService.getAllMessaggi();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Messaggio> getMessaggioById(@PathVariable Long id) {
        Optional<Messaggio> messaggio = messaggioService.getMessaggioById(id);
        return messaggio.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Messaggio createMessaggio(@RequestBody Messaggio messaggio) {
        return messaggioService.saveMessaggio(messaggio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessaggio(@PathVariable Long id) {
        messaggioService.deleteMessaggio(id);
        return ResponseEntity.noContent().build();
    }
}

