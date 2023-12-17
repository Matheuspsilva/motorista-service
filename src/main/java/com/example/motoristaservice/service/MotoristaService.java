package com.example.motoristaservice.service;

import com.example.motoristaservice.model.Motorista;
import com.example.motoristaservice.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public Motorista get(Long id) {
        return motoristaRepository.findById(id).orElse(null);
    }

    public Motorista create(Motorista motorista) {
        return motoristaRepository.save(motorista);
    }


    public List<Motorista> getAll() {
        return motoristaRepository.findAll();
    }

    public Motorista update(Long id, Motorista motorista) {
        Motorista motoristaSalvo = motoristaRepository.findById(id).orElseThrow(() -> new RuntimeException("Motorista não encontrado"));
        motoristaSalvo.setNome(motorista.getNome());
        motoristaSalvo.setCnh(motorista.getCnh());
        return motoristaRepository.save(motoristaSalvo);
    }

    public Motorista delete(Long id) {
        Motorista motorista = motoristaRepository.findById(id).orElse(null);
        motoristaRepository.deleteById(id);
        return motorista;
    }
}
