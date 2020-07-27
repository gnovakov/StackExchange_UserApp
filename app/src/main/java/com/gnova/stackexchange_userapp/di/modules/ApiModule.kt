package com.gnova.stackexchange_userapp.di.modules

import com.gnova.stackexchange_userapp.api.StackApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class ApiModule {

    @Provides
    @Reusable
    fun providesRetrofit(
        okHttpClient: OkHttpClient.Builder): StackApi =
        Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com/")
            .client(
                okHttpClient
                    .build()
            )
            .addConverterFactory( MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // Needed for Rx
            .build()
            .create(StackApi::class.java)

    @Provides
    @Reusable
    fun providesOkHttpClient(): OkHttpClient.Builder =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

}