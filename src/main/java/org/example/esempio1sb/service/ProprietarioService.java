package org.example.esempio1sb.service;


import org.example.esempio1sb.repository.ProprietarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    public List<Proprietario> getAllProprietari() {
        return proprietarioRepository.findAll();
    }

    public Proprietario saveProprietario(Proprietario proprietario) {
        return proprietarioRepository.save(proprietario);
    }

    public void deleteProprietario(String codProprietario) {
        proprietarioRepository.deleteById(codProprietario);
    }
}

