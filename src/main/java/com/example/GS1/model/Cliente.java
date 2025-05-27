package com.example.GS1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Calendar;

@Entity
@Table(name = "tb_user_cliente")
@SequenceGenerator(name = "cliente", sequenceName = "SQ_USER_CLIENTE_GS", allocationSize = 1)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Data
public class Cliente extends User{

    @Id
    @Column(name = "idCliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
    private Long id;

    public Cliente(String nomeUser, Calendar dataAniversario, String cpfUser, Endereco endereco) {
        super(nomeUser, dataAniversario, cpfUser, endereco);
    }
}
