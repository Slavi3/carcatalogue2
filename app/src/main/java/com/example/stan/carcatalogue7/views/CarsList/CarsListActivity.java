package com.example.stan.carcatalogue7.views.CarsList;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.stan.carcatalogue7.R;
import com.example.stan.carcatalogue7.models.Car;
import com.example.stan.carcatalogue7.views.BaseDrawerActivity;
import com.example.stan.carcatalogue7.views.CarDetails.CarDetailsActivity;
import com.example.stan.carcatalogue7.views.CarDetails.CarDetailsFragment;
import com.example.stan.carcatalogue7.views.CarDetails.CarDetailsPresenter;

import javax.inject.Inject;

import dagger.Module;
public class CarsListActivity extends
        BaseDrawerActivity
        implements CarsListContracts.Navigator {
    public static final long IDENTIFIER = 49;

    @Inject
    CarsListFragment mCarsListFragment;

    @Inject
    CarsListContracts.Presenter mCarsListPresenter;

    private boolean mIsPhone;
    private CarDetailsFragment mCarDetailsFragment;
    private CarDetailsPresenter mCarDetailsPresenter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_list);

        mToolbar = findViewById(R.id.drawer_toolbar);
        setSupportActionBar(mToolbar);

        mCarsListFragment.setNavigator(this);
        mCarsListFragment.setPresenter(mCarsListPresenter);

        mIsPhone = findViewById(R.id.content_details) == null;

        FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();

        transaction
                .replace(R.id.content, mCarsListFragment);

        if (!mIsPhone) {
            mCarDetailsFragment = CarDetailsFragment.newInstance();
            mCarDetailsFragment.setPresenter(mCarDetailsPresenter);
            transaction.replace(R.id.content_details, mCarDetailsFragment);
        }

        transaction.commit();
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }

    @Override
    public void navigateWith(Car car) {
        if (mIsPhone) {
            Intent intent = new Intent(
                    this,
                    CarDetailsActivity.class
            );

            intent.putExtra(CarDetailsActivity.EXTRA_KEY, car);

            startActivity(intent);
        } else {
            mCarDetailsPresenter.setCarId(car.getId());
            mCarDetailsPresenter.loadCar();
        }
    }
}

