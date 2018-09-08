package com.example.stan.carcatalogue7.views.CarsList;

import com.example.stan.carcatalogue7.async.AsyncRunner;
import com.example.stan.carcatalogue7.models.Car;
import com.example.stan.carcatalogue7.services.base.CarsService;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

public class CarsListPresenter
      implements CarsListContracts.Presenter

    {

        private final CarsService mCarsService;
        private final AsyncRunner mAsyncRunner;
        private CarsListContracts.View mView;

    @Inject
    public CarsListPresenter(
            CarsService carsService,
            AsyncRunner asyncRunner) {
        mCarsService = carsService;
        mAsyncRunner = asyncRunner;
    }

        @Override
        // same as // setView(SuperheroesListContracts.View view)
        public void subscribe (CarsListContracts.View view){
        mView = view;
    }

        @Override
        public void loadCars () {
        mView.showLoading();

        mAsyncRunner.runInBackground(() -> {
            try {
                List<Car> cars =
                        mCarsService.getAllCars();
                presentCarsToView(cars);
            } catch (IOException e) {
                e.printStackTrace();
                mView.showError(e);
            }
            mView.hideLoading();
        });
    }

        @Override
        public void filterCars (String pattern){
        mView.showLoading();
        mAsyncRunner.runInBackground(() -> {
            try {
                List<Car> cars =
                        mCarsService.getFilteredCars(pattern);
                presentCarsToView(cars);
            } catch (IOException e) {
                e.printStackTrace();
                mView.showError(e);
            }
            mView.hideLoading();
        });
    }

        @Override
        public void selectCar (Car car){
        mView.showCarDetails(car);
    }

        private void presentCarsToView (List< Car > cars) {
        if (cars.isEmpty()) {
            mView.showEmptyCarsList();
        } else {
            mView.showCars(cars);
        }
    }
    }


