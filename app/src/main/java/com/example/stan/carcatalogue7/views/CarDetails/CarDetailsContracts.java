package com.example.stan.carcatalogue7.views.CarDetails;

import com.example.stan.carcatalogue7.models.Car;

public interface CarDetailsContracts {
    interface View {
        void showCar(Car car);

        void setPresenter(Presenter presenter);

        void showError(Exception e);

        void showLoading();

        void hideLoading();
    }

    interface Presenter {
        void subscribe(View view);

        void loadCar();
    }
}
