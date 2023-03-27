package com.example.springpickytestcode.service;

import java.util.Map;

import com.example.springpickytestcode.ApiConnect;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ExchangeRateService {

    private final ApiConnect apiConnect;
    private static final String EXCHANGE_RATE_API_BASE_URL = "https://api.exchangeratesapi.io/latest";

    public void getExchangeRate() {
        WebClient webClient = WebClient.create(EXCHANGE_RATE_API_BASE_URL);

        Map a = webClient.get()
                .retrieve()
                .bodyToMono(Map.class)
                .block();


        System.out.println(a +"---");
/*
        return webClient.get()
                .retrieve()
                .bodyToMono(ExchangeRateResponse.class)
                .b
                .map(response -> response.getRates().get("USD"));*/
    }

    public String connect() {
        //ApiConnect.connect();
        System.out.println(apiConnect.connect());
       /* ApiConnect apiConnect = new ApiConnect();
        apiConnect.connect();*/
        System.out.println("하하");
        return "";
    }

}