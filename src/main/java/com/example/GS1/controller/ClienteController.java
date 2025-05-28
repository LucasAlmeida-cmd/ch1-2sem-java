package com.example.GS1.controller;

import com.example.GS1.DTO.UserPadraoDTO;
import com.example.GS1.model.Cliente;
import com.example.GS1.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService service;

    @Operation(summary = "Adiciona Cliente.", description = "Adiciona Cliente com as informações necessarias.")
    @PostMapping
    public ResponseEntity<Cliente> adicionar(
            @Parameter(description = "Corpo em Json com as informações.")
            @RequestBody UserPadraoDTO cliente){
        return ResponseEntity.ok(service.adicionarCliente(cliente));
    }

    @Operation(summary = "Retorna Clientes.", description = "Retorna todos os Clientes em baco.")
    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos(){
        List<Cliente> clientes = service.buscarTodos();
        return ResponseEntity.ok(clientes);
    }

    @Operation(summary = "Retorna Cliente", description = "Retorna o Cliente pelo ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorID(
            @Parameter(description = "ID do Cliente a ser buscado.", example = "1")
            @PathVariable Long id){
        Cliente cliente = service.buscarPorID(id);
        return ResponseEntity.ok(cliente);
    }

    @Operation(summary = "Atualiza Cliente", description = "Atualiza Cliente pelo ID.")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarPorID(
            @Parameter(description = "ID do Cliente a ser atualizado.", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Corpo do novo Cliente")
            @RequestBody UserPadraoDTO cliente){
        return ResponseEntity.ok(service.atulizarCliente(id, cliente));
    }

    @Operation(summary = "Deleta Cliente", description = "Deleta Cliente pelo ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deletarPorID(
            @Parameter(description = "ID do Admin a ser deletado.", example = "1")
            @PathVariable Long id){
        service.removerCliente(id);
        return ResponseEntity.noContent().build();
    }
}