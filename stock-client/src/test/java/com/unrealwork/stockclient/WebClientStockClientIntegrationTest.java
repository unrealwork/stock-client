package com.unrealwork.stockclient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static org.junit.jupiter.api.Assertions.*;

class WebClientStockClientIntegrationTest {
    private WebClient webClient = WebClient.builder().build();

    @Test
    void shouldRetrieveStockPricesFromTheService() {
        //given
        WebClientStockClient client = new WebClientStockClient(webClient);

        //when
        Flux<StockPrice> prices = client.pricesFor("SYMBOL");

        // then
        Assertions.assertNotNull(prices);
        Assertions.assertEquals(prices.take(5).count().block(),5);
        Assertions.assertEquals("SYMBOL", prices.blockFirst().getSymbol());

    }
}