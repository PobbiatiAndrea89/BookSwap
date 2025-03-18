package org.example.esempio1sb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppartamentoRepository extends JpaRepository<Appartamento, Integer> {
    List<Appartamento> findByCitta(String citta);
    List<Appartamento> findByProprietario_CodProprietario(String codProprietario);
}

