package com.example.GS1.controller;

import com.example.GS1.DTO.TempoDTO;
import com.example.GS1.service.OpenWeatherMapService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tempo")
public class TempoController {


    @Autowired
    private OpenWeatherMapService service;

    @Operation(summary = "Pesquisa Tempo.", description = "Pesquisa sobre o tempo de acordo com uma cidade.")
    @GetMapping("/{nomeCidade}")
    public ResponseEntity<TempoDTO> buscarDados(
            @Parameter(description = "Nome da Cidade.", example = "São Paulo")
            @PathVariable String nomeCidade){
        return ResponseEntity.ok(service.pegaDadosClima(nomeCidade));
    }
}
