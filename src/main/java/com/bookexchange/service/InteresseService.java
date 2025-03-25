package com.bookexchange.service;

import com.bookexchange.model.Interesse;
import com.bookexchange.repository.InteresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InteresseService {

    @Autowired
    private InteresseRepository interesseRepository;

    public List<Interesse> findByUtenteId(Long utenteId) {
        return interesseRepository.findByUtenteId(utenteId);
    }

    public Interesse saveInteresse(Interesse interesse) {
        return interesseRepository.save(interesse);
    }
}
