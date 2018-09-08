package com.example.stan.carcatalogue7.views.CarDetails;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.stan.carcatalogue7.R;
import com.example.stan.carcatalogue7.models.Car;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarDetailsFragment extends Fragment
        implements CarDetailsContracts.View

{
    private CarDetailsContracts.Presenter mPresenter;
    private TextView mMakeTextView;
    private TextView mModelTextView;
    private TextView mPowerTextView;
    private TextView mCubicCapacityTextView;

    public CarDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_car_details, container, false);

        mMakeTextView = view.findViewById(R.id.tv_make);
        mModelTextView = view.findViewById(R.id.tv_model);
        mPowerTextView = view.findViewById(R.id.tv_power);
        mCubicCapacityTextView = view.findViewById(R.id.tv_cubicCapacity);
        return view;
    }

    @Override
    public void onResume () {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadCar();
    }

    @Override
    public void showCar (Car car){
        runOnUi(() -> {
            mMakeTextView.setText(car.getMake());
            mModelTextView.setText(car.getModel());
            mPowerTextView.setText(car.getPower());
            mCubicCapacityTextView.setText(car.getCubicCapacity());
        });
    }

    @Override
    public void setPresenter (CarDetailsContracts.Presenter presenter){
        mPresenter = presenter;
    }

    @Override
    public void showError (Exception e){

    }

    @Override
    public void showLoading () {

    }

    @Override
    public void hideLoading () {

    }

    private void runOnUi (Runnable action){
        getActivity().runOnUiThread(action);
    }

    public static CarDetailsFragment newInstance () {
        return new CarDetailsFragment();
    }
}

