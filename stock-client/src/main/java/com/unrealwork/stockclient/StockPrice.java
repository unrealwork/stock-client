package com.unrealwork.stockclient;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockPrice {
    private String symbol;
    private Double price;
    private Instant instant;
}
