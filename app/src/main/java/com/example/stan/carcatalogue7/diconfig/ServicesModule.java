package com.example.stan.carcatalogue7.diconfig;

import com.example.stan.carcatalogue7.models.Car;
import com.example.stan.carcatalogue7.repositories.base.Repository;
import com.example.stan.carcatalogue7.services.HttpCarsService;
import com.example.stan.carcatalogue7.services.base.CarsService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServicesModule {
    @Provides
    public CarsService carsService(Repository<Car> repository) {
        return new HttpCarsService(repository);
    }
}
