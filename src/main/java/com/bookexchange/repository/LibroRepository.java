package com.bookexchange.repository;

import com.bookexchange.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByMateria(String materia);
    List<Libro> findByTitoloContaining(String titolo);
}
