package com.example.stan.carcatalogue7.views.CarDetails;

import com.example.stan.carcatalogue7.async.AsyncRunner;
import com.example.stan.carcatalogue7.models.Car;
import com.example.stan.carcatalogue7.services.base.CarsService;

import java.io.IOException;

public class CarDetailsPresenter
        implements CarDetailsContracts.Presenter {
        private final CarsService mCarsService;
        private final AsyncRunner mAsyncRunner;
        private CarDetailsContracts.View mView;
        private int mCarId;

    public CarDetailsPresenter(
                CarsService carsService,
                AsyncRunner asyncRunner
        ) {
            mCarsService = carsService;
            mAsyncRunner = asyncRunner;
        }

        @Override
        public void subscribe(CarDetailsContracts.View view) {
            mView = view;
        }

        @Override
        public void loadCar() {
            mView.showLoading();
            mAsyncRunner.runInBackground(() -> {
                try {
                    Car car = mCarsService.getDetailsById(mCarId);
                    mView.showCar(car);
                } catch (IOException e) {
                    e.printStackTrace();
                    mView.showError(e);
                }

                mView.hideLoading();
            });
        }

        public void setCarId(int carId) {
            mCarId = carId;
        }
    }

