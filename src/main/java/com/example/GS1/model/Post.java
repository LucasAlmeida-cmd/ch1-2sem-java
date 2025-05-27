package com.example.GS1.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Lob
    @Column(length = 1000000)
    private byte[] imagemBytes;

    @Column(name = "data_criacao")
    private LocalDateTime dataHoraAtual;


    public Post(String titulo, byte[] imagemBytes) {
        this.titulo = titulo;
        this.imagemBytes = imagemBytes;
        this.dataHoraAtual = LocalDateTime.now();
    }
}

