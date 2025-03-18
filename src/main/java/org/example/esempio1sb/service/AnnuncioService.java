package org.example.esempio1sb.service;

import org.example.esempio1sb.model.Annuncio;
import org.example.esempio1sb.repository.AnnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnnuncioService {

    @Autowired
    private AnnuncioRepository annuncioRepository;

    public Annuncio saveAnnuncio(Annuncio annuncio) {
        return annuncioRepository.save(annuncio);
    }

    public List<Annuncio> getAllAnnunci() {
        return annuncioRepository.findAll();
    }

    public Annuncio findById(Long id) {
        return annuncioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Annuncio non trovato!"));
    }

    public List<Annuncio> findByStato(String statoAnnuncio) {
        return annuncioRepository.findByStatoAnnuncio(statoAnnuncio);
    }
}
