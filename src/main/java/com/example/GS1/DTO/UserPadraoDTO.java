package com.example.GS1.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class UserPadraoDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nomeUser;
    @NotBlank(message = "A data é obrigatória")
    private String dataAniversario;
    @NotBlank(message = "O CPF é obrigatório")
    private String cpfUser;
    @NotBlank(message = "O CEP é obrigatório")
    private String cep;


}
