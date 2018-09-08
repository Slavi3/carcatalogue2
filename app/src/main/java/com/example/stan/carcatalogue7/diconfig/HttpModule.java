package com.example.stan.carcatalogue7.diconfig;



import com.example.stan.carcatalogue7.Constants;
import com.example.stan.carcatalogue7.http.HttpRequester;
import com.example.stan.carcatalogue7.http.OkHttpHttpRequester;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpModule {
    @Provides
    public HttpRequester httpRequester() {
        return new OkHttpHttpRequester();
    }

    @Provides
    @Named("baseServerUrl")
    public String baseServerUrl() {
        return Constants.BASE_SERVER_URL;
    }
}
