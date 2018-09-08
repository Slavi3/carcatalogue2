package com.example.stan.carcatalogue7.services;

import com.example.stan.carcatalogue7.models.Car;
import com.example.stan.carcatalogue7.repositories.base.Repository;
import com.example.stan.carcatalogue7.services.base.CarsService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class HttpCarsService implements CarsService {
    private final Repository<Car> mSuperheroesRepository;

    public HttpCarsService(Repository<Car> superheroesRepository) {
        mSuperheroesRepository = superheroesRepository;
    }

    @Override
    public List<Car> getAllCars() throws IOException {
        return mSuperheroesRepository.getAll();
    }

    @Override
    public Car getDetailsById(int id) throws IOException {
        return mSuperheroesRepository.getById(id);
    }

    @Override
    public List<Car> getFilteredCars(String pattern) throws IOException {
        String patternToLower = pattern.toLowerCase();

        return getAllCars().stream()
                .filter(car -> car.getMake().toLowerCase().contains(patternToLower))
                .collect(Collectors.toList());
    }
}
