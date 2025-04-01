package com.bookexchange.service;

import com.bookexchange.model.Utente;
import com.bookexchange.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    @Transactional
    public void saveUtente(Utente utente) {
        utenteRepository.save(utente);
    }

    public Utente findById(Long id) {
        return utenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utente non trovato!"));
    }

    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }

    public Optional<Utente> findByEmail(String email) {
        return utenteRepository.findByEmail(email);
    }
}
