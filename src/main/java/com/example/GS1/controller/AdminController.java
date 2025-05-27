package com.example.GS1.controller;

import com.example.GS1.DTO.UserPadraoDTO;
import com.example.GS1.model.Admin;
import com.example.GS1.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping
    public ResponseEntity<Admin> adicionarAdmin(@RequestBody UserPadraoDTO admin){
        return ResponseEntity.ok(service.adicionarAdmin(admin));
    }

    @GetMapping
    public ResponseEntity<List<Admin>> buscarTodos(){
        List<Admin> list = service.buscarTodos();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> buscarPorID(@PathVariable Long id){
        Admin admin = service.buscarPorID(id);
        return ResponseEntity.ok(admin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> atualizarPorID(@PathVariable Long id, @RequestBody UserPadraoDTO admin){
        return ResponseEntity.ok(service.atualizarAdmin(id, admin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Admin> deletarPorID(@PathVariable Long id){
        service.removerAdmin(id);
        return ResponseEntity.noContent().build();
    }

}
