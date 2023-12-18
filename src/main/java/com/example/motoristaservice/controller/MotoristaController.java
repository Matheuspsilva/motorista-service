package com.example.motoristaservice.controller;

import com.example.motoristaservice.model.Motorista;
import com.example.motoristaservice.service.MotoristaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class MotoristaController {

    private static final Logger log = LoggerFactory.getLogger(MotoristaController.class);
    @Autowired
    private MotoristaService motoristaService;

    //Injeção de dependência
    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    @GetMapping("/motoristas/{id}")
    public ResponseEntity<Motorista> get(@PathVariable("id") Long id) {
        log.info("Buscando motorista por id: {}", id);
        return ResponseEntity.ok(motoristaService.get(id));
    }

    @GetMapping("/motoristas")
    public ResponseEntity<List<Motorista>> getAll() {
        log.info("Buscando todos os motoristas");
        return ResponseEntity.ok(motoristaService.getAll());
    }


    @PostMapping("/motoristas")
    public ResponseEntity<Motorista> create(@RequestBody Motorista motorista) {
        log.info("Criando motorista: {}", motorista);
        return ResponseEntity.ok(motoristaService.create(motorista));
    }

    @PutMapping("/motoristas/{id}")
    public ResponseEntity<Motorista> update(@PathVariable("id") Long id, @RequestBody Motorista motorista) {
        log.info("Atualizando motorista: {}", motorista);
        return ResponseEntity.ok(motoristaService.update(id, motorista));
    }

    @DeleteMapping("/motoristas/{id}")
    public ResponseEntity<Motorista> delete(@PathVariable("id") Long id) {
        log.info("Deletando motorista por id: {}", id);
        return ResponseEntity.ok(motoristaService.delete(id));
    }


}
