package com.bookexchange.esempio1sb.repository;

import com.bookexchange.esempio1sb.model.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecensioneRepository extends JpaRepository<Recensione, Long> {
    List<Recensione> findByRecensitoId(Long recensitoId);
}