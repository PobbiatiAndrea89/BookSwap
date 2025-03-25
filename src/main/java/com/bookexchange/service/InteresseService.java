package com.bookexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookexchange.model.Interesse;
import com.bookexchange.repository.InteresseRepository;
import java.util.List;
import java.util.Optional;

@Service
public class InteresseService {

    @Autowired
    private InteresseRepository interesseRepository;

    public List<Interesse> getAllInteressi() {
        return interesseRepository.findAll();
    }

    public Optional<Interesse> getInteresseById(Long id) {
        return interesseRepository.findById(id);
    }

    public Interesse saveInteresse(Interesse interesse) {
        return interesseRepository.save(interesse);
    }

    public void deleteInteresse(Long id) {
        interesseRepository.deleteById(id);
    }
}

