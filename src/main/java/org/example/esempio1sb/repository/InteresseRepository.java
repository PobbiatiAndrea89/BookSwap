package com.bookexchange.esempio1sb.repository;

import com.bookexchange.esempio1sb.model.Interesse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InteresseRepository extends JpaRepository<Interesse, Long> {
    List<Interesse> findByUtenteId(Long utenteId);
}

