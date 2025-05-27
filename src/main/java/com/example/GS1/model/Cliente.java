package com.example.GS1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Calendar;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "tb_user_cliente")
public class Cliente extends User {

    public Cliente(String nomeUser, Calendar dataAniversario, String cpfUser, Endereco endereco) {
        super(nomeUser, dataAniversario, cpfUser, endereco);
    }
}
