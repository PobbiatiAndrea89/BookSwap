package com.bookexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookexchange.model.Messaggio;
import com.bookexchange.repository.MessaggioRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MessaggioService {

    @Autowired
    private MessaggioRepository messaggioRepository;

    public List<Messaggio> getAllMessaggi() {
        return messaggioRepository.findAll();
    }

    public Optional<Messaggio> getMessaggioById(Long id) {
        return messaggioRepository.findById(id);
    }

    public Messaggio saveMessaggio(Messaggio messaggio) {
        return messaggioRepository.save(messaggio);
    }

    public void deleteMessaggio(Long id) {
        messaggioRepository.deleteById(id);
    }
}
