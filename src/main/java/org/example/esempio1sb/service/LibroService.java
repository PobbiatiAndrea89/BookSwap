package org.example.esempio1sb.service;

import org.example.esempio1sb.model.Libro;
import org.example.esempio1sb.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
