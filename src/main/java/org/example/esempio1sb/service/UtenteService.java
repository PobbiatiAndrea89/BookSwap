package org.example.esempio1sb.service;

import org.example.esempio1sb.model.Utente;
import org.example.esempio1sb.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente saveUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public Utente findById(Long id) {
        return utenteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Utente non trovato!"));
    }

    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }
}
