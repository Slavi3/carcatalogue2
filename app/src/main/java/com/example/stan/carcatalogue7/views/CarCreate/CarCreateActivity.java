package com.example.stan.carcatalogue7.views.CarCreate;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.stan.carcatalogue7.R;
import com.example.stan.carcatalogue7.views.BaseDrawerActivity;


public class CarCreateActivity extends BaseDrawerActivity {
    public static final long IDENTIFIER = 298;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_create);
        mToolbar = findViewById(R.id.drawer_toolbar);
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }
}

