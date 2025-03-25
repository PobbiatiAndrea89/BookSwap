package com.bookexchange.service;

import com.bookexchange.model.Recensione;
import com.bookexchange.repository.RecensioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecensioneService {

    @Autowired
    private RecensioneRepository recensioneRepository;

    public List<Recensione> findByRecensitoId(Long recensitoId) {
        return recensioneRepository.findByRecensitoId(recensitoId);
    }

    public Recensione saveRecensione(Recensione recensione) {
        return recensioneRepository.save(recensione);
    }
}