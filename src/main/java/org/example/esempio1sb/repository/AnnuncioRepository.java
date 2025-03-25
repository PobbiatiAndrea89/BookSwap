package com.bookexchange.esempio1sb.repository;

import com.bookexchange.esempio1sb.model.Annuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnnuncioRepository extends JpaRepository<Annuncio, Long> {
    List<Annuncio> findByStatoAnnuncio(String statoAnnuncio);
}