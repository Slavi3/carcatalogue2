package com.example.stan.carcatalogue7.diconfig;

import com.example.stan.carcatalogue7.async.AsyncRunner;
import com.example.stan.carcatalogue7.async.AsyncRunnerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AsyncModule {
    @Provides
    @Singleton
    public AsyncRunner asyncRunner() {
        return new AsyncRunnerImpl();
    }
}
