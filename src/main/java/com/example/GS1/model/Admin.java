package com.example.GS1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "tb_user_admin")
public class Admin extends User {

    public Admin(String nomeUser, Calendar dataAniversario, String cpfUser, Endereco endereco) {
        super(nomeUser, dataAniversario, cpfUser, endereco);
    }
}
