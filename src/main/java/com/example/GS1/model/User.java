package com.example.GS1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;


@Entity
@Table(name = "tb_user_gs")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gs")
    @SequenceGenerator(name = "user_seq_gs", sequenceName = "SQ_USER_GS", allocationSize = 1)
    private Long id;

    @Column(name = "nome_usuario", nullable = false, length = 80)
    private String nomeUser;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_aniversario_usuario", nullable = false)
    private Calendar dataAniversario;

    @Column(name = "cpf_usuario", nullable = false, length = 14, unique = true)
    private String cpfUser;

    @Embedded
    private Endereco endereco;

    public User(String nomeUser, Calendar dataAniversario, String cpfUser, Endereco endereco) {
        this.nomeUser = nomeUser;
        this.dataAniversario = dataAniversario;
        this.cpfUser = cpfUser;
        this.endereco = endereco;
    }

    public User() {}
}
