package com.example.GS1.controller;

import com.example.GS1.DTO.UserPadraoDTO;
import com.example.GS1.model.Admin;
import com.example.GS1.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @Operation(summary = "Adiciona Admin.", description = "Adiciona Admin com as informações necessarias.")
    @PostMapping
    public ResponseEntity<Admin> adicionarAdmin(
            @Parameter(description = "Corpo em Json com as informações.")
            @RequestBody UserPadraoDTO admin){
        return ResponseEntity.ok(service.adicionarAdmin(admin));
    }

    @Operation(summary = "Retorna Admins.", description = "Retorna todos os Admins em baco.")
    @GetMapping
    public ResponseEntity<List<Admin>> buscarTodos(){
        List<Admin> list = service.buscarTodos();
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Retorna Admin", description = "Retorna o Admin pelo ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Admin> buscarPorID(
            @Parameter(description = "ID do Admin a ser buscado.", example = "1")
            @PathVariable Long id){
        Admin admin = service.buscarPorID(id);
        return ResponseEntity.ok(admin);
    }

    @Operation(summary = "Atualiza Admin", description = "Atualiza Admin pelo ID.")
    @PutMapping("/{id}")
    public ResponseEntity<Admin> atualizarPorID(
            @Parameter(description = "ID do Admin a ser atualizado.", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Corpo do novo Admin")
            @RequestBody UserPadraoDTO admin){
        return ResponseEntity.ok(service.atualizarAdmin(id, admin));
    }

    @Operation(summary = "Deleta Admin", description = "Deleta Admin pelo ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Admin> deletarPorID(
            @Parameter(description = "ID do Admin a ser deletado.", example = "1")
            @PathVariable Long id){
        service.removerAdmin(id);
        return ResponseEntity.noContent().build();
    }

}
