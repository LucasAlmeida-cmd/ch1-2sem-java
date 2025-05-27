package com.example.GS1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TempoDTO {
    private Main main;
    private List<Weather> weather;
    private String name;
}
