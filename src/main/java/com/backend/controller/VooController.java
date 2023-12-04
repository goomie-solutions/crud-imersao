package com.backend.controller;

import com.backend.entidades.Voo;
import com.backend.servicos.VooServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/voos")
public class VooController {

    @Autowired
    private VooServico servico;

    @GetMapping("/{id}")
    public ResponseEntity<Voo> buscaPorId(@PathVariable UUID id) {
        Voo voo = servico.consultaVoo(id);
        return ResponseEntity.ok().body(voo);
    }

    @PostMapping
    public ResponseEntity<Voo> criaVoo(@RequestBody Voo requisicao) {
        Voo voo = servico.registraVoo(requisicao);
        return ResponseEntity.ok().body(voo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaVoo(@PathVariable UUID id) {
        servico.deletaVoo(id);
        return ResponseEntity.noContent().build();
    }


}
