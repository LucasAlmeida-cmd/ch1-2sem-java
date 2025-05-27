package com.example.GS1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class EnderecoRecords {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
