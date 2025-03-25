package com.bookexchange.esempio1sb.repository;

import com.bookexchange.esempio1sb.model.Messaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessaggioRepository extends JpaRepository<Messaggio, Long> {
    List<Messaggio> findByMittenteId(Long mittenteId);
    List<Messaggio> findByDestinatarioId(Long destinatarioId);
}