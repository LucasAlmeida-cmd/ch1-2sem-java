package com.example.GS1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class User {

    @Column(name = "nome_usuario", nullable = false, length = 80)
    private String nomeUser;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_aniversario_usuario", nullable = false)
    private Calendar dataAniversario;

    @Column(name = "cpf_usuario", nullable = false, length = 14, unique = true)
    private String cpfUser;

    @Embedded
    private Endereco endereco;



}
