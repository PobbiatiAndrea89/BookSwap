package com.bookexchange.repository;

import com.bookexchange.model.Interesse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InteresseRepository extends JpaRepository<Interesse, Long> {
    List<Interesse> findByUtenteId(Long utenteId);
}

