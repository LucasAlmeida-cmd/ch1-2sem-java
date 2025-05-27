package com.example.GS1.controller;

import com.example.GS1.DTO.TempoDTO;
import com.example.GS1.service.OpenWeatherMapService;
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


    @GetMapping("/{nomeCidade}")
    public ResponseEntity<TempoDTO> buscarDados(@PathVariable String nomeCidade){
        return ResponseEntity.ok(service.pegaDadosClima(nomeCidade));
    }
}
