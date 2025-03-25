package com.bookexchange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookexchange.model.Utente;
import com.bookexchange.model.Libro;
import com.bookexchange.model.Annuncio;
import com.bookexchange.model.Messaggio;
import com.bookexchange.model.Recensione;
import com.bookexchange.model.Interesse;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
