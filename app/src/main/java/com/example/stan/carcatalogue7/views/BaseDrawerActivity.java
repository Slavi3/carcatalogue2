package com.example.stan.carcatalogue7.views;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.example.stan.carcatalogue7.views.CarCreate.CarCreateActivity;
import com.example.stan.carcatalogue7.views.CarsList.CarsListActivity;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {
    public BaseDrawerActivity() {

    }

    public void setupDrawer() {
        PrimaryDrawerItem listSuperheroesItem = new PrimaryDrawerItem()
                .withIdentifier(CarsListActivity.IDENTIFIER)
                .withName("Cars");

        PrimaryDrawerItem createSuperheroItem = new PrimaryDrawerItem()
                .withIdentifier(CarCreateActivity.IDENTIFIER)
                .withIcon(android.R.drawable.btn_plus)
                .withName("Create car");

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(getDrawerToolbar())
                .addDrawerItems(
                        listSuperheroesItem,
                        new DividerDrawerItem(),
                        createSuperheroItem
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(
                            View view,
                            int position,
                            IDrawerItem drawerItem) {
                        long identifier = drawerItem.getIdentifier();

                        if (getIdentifier() == identifier) {
                            return false;
                        }

                        Intent intent = getNextIntent(identifier);
                        if (intent == null) {
                            return false;
                        }

                        startActivity(intent);
                        return true;
                    }
                })
                .build();
    }

    private Intent getNextIntent(long identifier) {
        return new Intent(this, CarsListActivity.class);
    }

    protected abstract long getIdentifier();

    protected abstract Toolbar getDrawerToolbar();

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }
}
