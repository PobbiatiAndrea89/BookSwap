package com.bookexchange.repository;

import com.bookexchange.model.Annuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnnuncioRepository extends JpaRepository<Annuncio, Long> {
    List<Annuncio> findByStatoAnnuncio(String statoAnnuncio);
}