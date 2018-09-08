package com.example.stan.carcatalogue7.views.CarDetails;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.stan.carcatalogue7.R;
import com.example.stan.carcatalogue7.models.Car;
import com.example.stan.carcatalogue7.services.base.CarsService;

public class CarDetailsActivity extends Activity {

    public static final String EXTRA_KEY = "CAR_EXTRA_KEY";

    private CarDetailsFragment mCarDetailsFragment;
    private CarDetailsPresenter mCarDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        CarsService carsService = null;

        Intent intent = getIntent();
        Car car = (Car) intent.getSerializableExtra(CarDetailsActivity.EXTRA_KEY);
        mCarDetailsPresenter.setCarId(car.getId());

        mCarDetailsFragment = CarDetailsFragment.newInstance();
        mCarDetailsFragment.setPresenter(mCarDetailsPresenter);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mCarDetailsFragment)
                .commit();
    }
}

