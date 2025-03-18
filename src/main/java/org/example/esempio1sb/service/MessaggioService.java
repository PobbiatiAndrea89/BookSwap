package org.example.esempio1sb.service;

import org.example.esempio1sb.model.Messaggio;
import org.example.esempio1sb.repository.MessaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MessaggioService {

    @Autowired
    private MessaggioRepository messaggioRepository;

    public List<Messaggio> findMessaggiByMittente(Long mittenteId) {
        return messaggioRepository.findByMittenteId(mittenteId);
    }

    public List<Messaggio> findMessaggiByDestinatario(Long destinatarioId) {
        return messaggioRepository.findByDestinatarioId(destinatarioId);
    }

    public Messaggio sendMessaggio(Messaggio messaggio) {
        return messaggioRepository.save(messaggio);
    }
}
