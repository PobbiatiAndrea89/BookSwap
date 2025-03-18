package org.example.esempio1sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffittoRepository extends JpaRepository<Affitto, Integer> {
}

