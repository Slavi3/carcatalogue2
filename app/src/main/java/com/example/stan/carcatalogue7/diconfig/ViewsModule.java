package com.example.stan.carcatalogue7.diconfig;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.stan.carcatalogue7.models.Car;
import com.example.stan.carcatalogue7.views.CarsList.CarsListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewsModule {
    @Provides
    public ArrayAdapter<Car> carArrayAdapter(Context context) {
        return new CarsListAdapter(context);
    }
}
