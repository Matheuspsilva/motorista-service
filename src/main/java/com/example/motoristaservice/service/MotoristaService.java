package com.example.motoristaservice.service;

import com.example.motoristaservice.model.Motorista;
import com.example.motoristaservice.repository.MotoristaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    private static final Logger log = LoggerFactory.getLogger(MotoristaService.class);
    @Autowired
    private MotoristaRepository motoristaRepository;

    public Motorista get(Long id)
    {
        log.info("Buscando motorista por id: {}", id);
        return motoristaRepository.findById(id).orElse(null);
    }

    public Motorista create(Motorista motorista) {
        log.info("Criando motorista: {}", motorista);
        return motoristaRepository.save(motorista);
    }


    public List<Motorista> getAll() {
        log.info("Buscando todos os motoristas");
        return motoristaRepository.findAll();
    }

    public Motorista update(Long id, Motorista motorista) {
        //show tracer and span
        log.info("Atualizando motorista: {}", motorista);
        Motorista motoristaSalvo = motoristaRepository.findById(id).orElseThrow(() -> new RuntimeException("Motorista não encontrado"));
        motoristaSalvo.setNome(motorista.getNome());
        motoristaSalvo.setCnh(motorista.getCnh());
        return motoristaRepository.save(motoristaSalvo);
    }

    public Motorista delete(Long id) {
        log.info("Deletando motorista por id: {}", id);
        Motorista motorista = motoristaRepository.findById(id).orElse(null);
        motoristaRepository.deleteById(id);
        return motorista;
    }
}
