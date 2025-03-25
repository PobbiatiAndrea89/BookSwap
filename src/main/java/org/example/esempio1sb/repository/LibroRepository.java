package com.bookexchange.esempio1sb.repository;

import com.bookexchange.esempio1sb.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByMateria(String materia);
    List<Libro> findByTitoloContaining(String titolo);
}
