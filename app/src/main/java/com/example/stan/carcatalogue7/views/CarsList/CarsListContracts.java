package com.example.stan.carcatalogue7.views.CarsList;
import com.example.stan.carcatalogue7.models.Car;

import java.util.List;

public interface CarsListContracts {
    interface View {
        void setPresenter(Presenter presenter);

        void showCars(List<Car> cars);

        void showEmptyCarsList();

        void showError(Exception e);

        void showLoading();

        void hideLoading();

        void showCarDetails(Car car);
    }

    interface Presenter {
        void subscribe(View view);

        void loadCars();

        void filterCars(String pattern);

        void selectCar(Car car);
    }

    interface Navigator {
        void navigateWith(Car car);
    }
}
