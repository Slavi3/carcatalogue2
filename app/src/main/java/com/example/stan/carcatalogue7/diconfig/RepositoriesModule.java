package com.example.stan.carcatalogue7.diconfig;

import com.example.stan.carcatalogue7.http.HttpRequester;
import com.example.stan.carcatalogue7.models.Car;
import com.example.stan.carcatalogue7.parsers.base.JsonParser;
import com.example.stan.carcatalogue7.repositories.HttpRepository;
import com.example.stan.carcatalogue7.repositories.base.Repository;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {
    @Provides
    @Singleton
    public Repository<Car> carRepository(
            @Named("baseServerUrl") String baseServerUrl,
            HttpRequester httpRequester,
            JsonParser<Car> jsonParser
    ) {
        String url = baseServerUrl + "/superheros";
        return new HttpRepository<>(url, httpRequester, jsonParser);
    }

}
