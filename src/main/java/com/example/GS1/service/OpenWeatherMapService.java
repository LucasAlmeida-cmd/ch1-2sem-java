package com.example.GS1.service;


import com.example.GS1.DTO.TempoDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class OpenWeatherMapService {
    private final RestTemplate restTemplate;
    private static final String API_KEY = "887e908f891ca36111b3429196529312";
    private static final String COMECO_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private static final String MEIO_URL = ",BR&appid=";
    private static final String FIM_URL = "&units=metric&lang=pt_br";

    public OpenWeatherMapService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public TempoDTO pegaDadosClima(String cidade){
        String urlString = COMECO_URL + cidade + MEIO_URL + API_KEY + FIM_URL;
        TempoDTO response = restTemplate.getForObject(urlString, TempoDTO.class);
        if (response == null){
            throw new RuntimeException("Cidade Não Encontrada");
        }
        return response;
    }
}
