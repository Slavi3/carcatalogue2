package com.example.stan.carcatalogue7.views.CarsList;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.stan.carcatalogue7.R;
import com.example.stan.carcatalogue7.models.Car;

import javax.inject.Inject;

public class CarsListAdapter extends ArrayAdapter<Car> {
    @Inject
    public CarsListAdapter(@NonNull Context context) {
        super(context, -1);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(
                R.layout.car_item,
                parent,
                false
        );

        TextView makeTextView = view.findViewById(R.id.tv_make);
        TextView modelTextView = view.findViewById(R.id.tv_model);
        TextView powerTextView = view.findViewById(R.id.tv_power);
        TextView cubicCapacityTextView = view.findViewById(R.id.tv_cubicCapacity);

        Car car = getItem(position);

        makeTextView.setText(car.getMake());
        modelTextView.setText(car.getModel());
        powerTextView.setText(car.getPower());
        cubicCapacityTextView.setText(car.getCubicCapacity());

        return view;
    }
}

