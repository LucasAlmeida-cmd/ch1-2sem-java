package com.example.GS1.controller;

import com.example.GS1.DTO.UserPadraoDTO;
import com.example.GS1.model.Cliente;
import com.example.GS1.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> adicionar(@RequestBody UserPadraoDTO cliente){
        return ResponseEntity.ok(service.adicionarCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos(){
        List<Cliente> clientes = service.buscarTodos();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorID(@PathVariable Long id){
        Cliente cliente = service.buscarPorID(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarPorID(@PathVariable Long id, @RequestBody UserPadraoDTO cliente){
        return ResponseEntity.ok(service.atulizarCliente(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletarPorID(@PathVariable Long id){
        service.removerCliente(id);
        return ResponseEntity.noContent().build();
    }
}