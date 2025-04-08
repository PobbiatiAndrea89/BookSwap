package com.bookexchange.service;

import com.bookexchange.model.Libro;
import com.bookexchange.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public List<Libro> getAllLibri() {
        return libroRepository.findAll();
    }

    public Libro findById(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro non trovato!"));
    }

    public List<Libro> findByTitolo(String titolo) {
        return libroRepository.findByTitoloContaining(titolo);
    }

    public List<Libro> findByMateria(String materia) {
        return libroRepository.findByMateria(materia);
    }
    public List<Libro> filtraLibri(String titolo, String materia, Libro.StatoLibro stato, BigDecimal prezzoMax) {
        return libroRepository.findAll().stream()
                .filter(libro -> titolo == null || libro.getTitolo().toLowerCase().contains(titolo.toLowerCase()))
                .filter(libro -> materia == null || libro.getMateria().equalsIgnoreCase(materia))
                .filter(libro -> stato == null || libro.getStato() == stato)
                .filter(libro -> prezzoMax == null || libro.getPrezzo().compareTo(prezzoMax) <= 0)
                .toList();
    }


}
