package com.example.springpickytestcode.test;

import com.example.springpickytestcode.ApiConnect;
import com.example.springpickytestcode.service.ExchangeRateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class ExchangeRateServiceTest {

    @InjectMocks
    ExchangeRateService exchangeRateService;

    @Mock
    ApiConnect apiConnect;
    @Test
    void zzz(){
        exchangeRateService.getExchangeRate();

    }

    private static final String EXCHANGE_RATE_API_BASE_URL = "https://api.exchangeratesapi.io/latest";

    @Test
    public void getExchangeRate() {
       /* WebClient webClient = WebClient.create(EXCHANGE_RATE_API_BASE_URL);

        Map a = webClient.get()
                .retrieve()
                .bodyToMono(Map.class)
                .block();*/
        System.out.println(getSafeDrinkingWaterRate() +"--");
    }
    private static final String WORLD_BANK_WATER_API_BASE_URL = "https://api.worldbank.org/v2/countries/all/indicators/SH.H2O.SMDW.ZS?format=json";

    public Map getSafeDrinkingWaterRate() {
        WebClient webClient = WebClient.create(WORLD_BANK_WATER_API_BASE_URL);
        return webClient.get()
                .uri(WORLD_BANK_WATER_API_BASE_URL)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
              /*  .flatMapIterable(waterResponses -> Arrays.asList(waterResponses))
                .filter(response -> response.getValue() != null)
                .map(WaterResponse::getValue)
                .next();*/
    }


    @Test
    public void getExchangeRate2() {
       /* WebClient webClient = WebClient.create(EXCHANGE_RATE_API_BASE_URL);

        Map a = webClient.get()
                .retrieve()
                .bodyToMono(Map.class)
                .block();*/
       // Mockito.when() // bean이 아닌 놈에 대한 stub은 어떻게 하지?

        Mockito.when(apiConnect.connect()).thenReturn(true);
        System.out.println(exchangeRateService.connect() +"짠");
    }
}
