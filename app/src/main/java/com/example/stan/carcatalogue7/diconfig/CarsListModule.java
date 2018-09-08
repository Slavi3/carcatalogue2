package com.example.stan.carcatalogue7.diconfig;

import com.example.stan.carcatalogue7.views.CarsList.CarsListContracts;
import com.example.stan.carcatalogue7.views.CarsList.CarsListFragment;
import com.example.stan.carcatalogue7.views.CarsList.CarsListPresenter;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class CarsListModule {
    @FragmentScoped
    @ContributesAndroidInjector
    abstract CarsListFragment superheroesListFragment();

    @ActivityScoped
    @Binds
    abstract CarsListContracts.Presenter taskPresenter(CarsListPresenter presenter);
}
