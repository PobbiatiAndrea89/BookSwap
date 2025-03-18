package org.example.esempio1sb.service;

import org.example.esempio1sb.repository.AffittoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AffittoService {

    private final AffittoRepository affittoRepository;

    public Affitto saveAffitto(Affitto affitto) {
        return affittoRepository.save(affitto);
    }
}

