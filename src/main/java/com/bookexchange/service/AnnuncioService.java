package com.bookexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookexchange.model.Annuncio;
import com.bookexchange.repository.AnnuncioRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AnnuncioService {

    @Autowired
    private AnnuncioRepository annuncioRepository;

    public List<Annuncio> getAllAnnunci() {
        return annuncioRepository.findAll();
    }

    public Optional<Annuncio> getAnnuncioById(Long id) {
        return annuncioRepository.findById(id);
    }

    public Annuncio saveAnnuncio(Annuncio annuncio) {
        return annuncioRepository.save(annuncio);
    }

    public void deleteAnnuncio(Long id) {
        annuncioRepository.deleteById(id);
    }
}

