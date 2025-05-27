package com.example.GS1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Entity
@Table(name = "tb_user_admin")
@SequenceGenerator(name = "admin", sequenceName = "SQ_USER_ADMIN_GS", allocationSize = 1)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@Data
public class Admin extends User{

    @Id
    @Column(name = "idAdmin")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin")
    private Long id;

    public Admin(String nomeUser, Calendar dataAniversario, String cpfUser, Endereco endereco) {
        super(nomeUser, dataAniversario, cpfUser, endereco);
    }
}
