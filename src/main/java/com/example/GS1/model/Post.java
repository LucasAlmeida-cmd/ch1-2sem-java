package com.example.GS1.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tb_post")
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

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    public Post(String titulo, byte[] imagemBytes, User usuario) {
        this.titulo = titulo;
        this.imagemBytes = imagemBytes;
        this.dataHoraAtual = LocalDateTime.now();
        this.usuario = usuario;
    }
}
