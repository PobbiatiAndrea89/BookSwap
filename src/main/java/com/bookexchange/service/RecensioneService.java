package com.bookexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookexchange.model.Recensione;
import com.bookexchange.repository.RecensioneRepository;
import java.util.List;
import java.util.Optional;

@Service
public class RecensioneService {

    @Autowired
    private RecensioneRepository recensioneRepository;

    public List<Recensione> getAllRecensioni() {
        return recensioneRepository.findAll();
    }

    public Optional<Recensione> getRecensioneById(Long id) {
        return recensioneRepository.findById(id);
    }

    public Recensione saveRecensione(Recensione recensione) {
        return recensioneRepository.save(recensione);
    }

    public void deleteRecensione(Long id) {
        recensioneRepository.deleteById(id);
    }
}

