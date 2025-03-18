package org.example.esempio1sb.service;


import org.example.esempio1sb.repository.AppartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppartamentoService {

    private final AppartamentoRepository appartamentoRepository;

    public List<Appartamento> findByCitta(String citta) {
        return appartamentoRepository.findByCitta(citta);
    }

    public List<Appartamento> findByProprietario(String codProprietario) {
        return appartamentoRepository.findByProprietario_CodProprietario(codProprietario);
    }

    public Appartamento saveAppartamento(Appartamento appartamento) {
        return appartamentoRepository.save(appartamento);
    }

    public void deleteAppartamento(int codAppartamento) {
        appartamentoRepository.deleteById(codAppartamento);
    }
}
