package com.bookexchange.repository;

import com.bookexchange.model.Messaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessaggioRepository extends JpaRepository<Messaggio, Long> {
    List<Messaggio> findByMittenteId(Long mittenteId);
    List<Messaggio> findByDestinatarioId(Long destinatarioId);
}