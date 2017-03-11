package com.bubelov.coins.util;

import com.bubelov.coins.model.ExchangeRate;

/**
 * Author: Igor Bubelov
 * Date: 10/7/15 9:24 AM
 */

public class ExchangeRatesFactory {
    public static ExchangeRate newExchangeRate(String currency, String baseCurrency, float value) {
        ExchangeRate rate = new ExchangeRate();
        rate.setCurrency(currency);
        rate.setBaseCurrency(baseCurrency);
        rate.setValue(value);
        return rate;
    }
}