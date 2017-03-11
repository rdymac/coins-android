package com.bubelov.coins.api.rates.provider;

import com.bubelov.coins.api.rates.BitcoinAverageApi;
import com.bubelov.coins.model.ExchangeRate;
import com.bubelov.coins.util.ExchangeRatesFactory;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author: Igor Bubelov
 * Date: 10/4/15 6:58 PM
 */

public class BitcoinAverageExchangeRatesProvider extends JsonApiRatesProvider {
    private BitcoinAverageApi api;

    public BitcoinAverageExchangeRatesProvider() {
        api = new Retrofit.Builder()
                .baseUrl("https://api.bitcoinaverage.com/")
                .addConverterFactory(GsonConverterFactory.create(getGsonForApis()))
                .build()
                .create(BitcoinAverageApi.class);
    }

    @Override
    public ExchangeRate getExchangeRate(String currency, String baseCurrency) throws IOException {
        if ("BTC".equalsIgnoreCase(currency) && "USD".equalsIgnoreCase(baseCurrency)) {
            return ExchangeRatesFactory.newExchangeRate(
                    currency,
                    baseCurrency,
                    api.getUsdTicker().execute().body().getLast()
            );
        }

        throw new UnsupportedOperationException("Unsupported currency pair");
    }
}