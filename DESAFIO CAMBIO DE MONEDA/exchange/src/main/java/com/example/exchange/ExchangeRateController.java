package com.example.exchange;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
public class ExchangeRateController {

    private static final String API_KEY = "YOUR API KEY HERE(SU API KEY AQUI)";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    @GetMapping("/exchange-rate")
    public Map getExchangeRate(@RequestParam String baseCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL + baseCurrency).toUriString();
        return restTemplate.getForObject(url, Map.class);
    }
}