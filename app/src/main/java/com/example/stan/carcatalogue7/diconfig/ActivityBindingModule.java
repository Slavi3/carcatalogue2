package com.example.stan.carcatalogue7.diconfig;

import com.example.stan.carcatalogue7.views.CarsList.CarsListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {
    @ActivityScoped
    @ContributesAndroidInjector()
    abstract CarsListActivity carsListActivity();


}