package com.example.GS1.DTO;

import lombok.Data;

@Data
public class PostDTO {
    private String titulo;
    private byte[] imagemBytes;
    private Long usuarioId;
}
