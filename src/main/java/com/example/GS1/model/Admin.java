package com.example.GS1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Data
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id_admin")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "tb_user_admin_gs")
public class Admin extends User {

    public Admin(String nomeUser, Calendar dataAniversario, String cpfUser, Endereco endereco) {
        super(nomeUser, dataAniversario, cpfUser, endereco);
    }
}
