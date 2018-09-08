package com.example.stan.carcatalogue7.diconfig;



import com.example.stan.carcatalogue7.models.Car;
import com.example.stan.carcatalogue7.parsers.GsonJsonParser;
import com.example.stan.carcatalogue7.parsers.base.JsonParser;

import dagger.Module;
import dagger.Provides;

@Module
public class ParsersModule {
    @Provides
    public JsonParser<Car> carJsonParser() {
        return new GsonJsonParser<>(Car.class, Car[].class);
    }
}
