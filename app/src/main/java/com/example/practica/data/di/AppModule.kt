package com.example.practica.data.di

import com.example.practica.data.remote.api.CountryApi.CountryApi
import com.example.practica.data.remote.repository.CountryRepositoryImpl.kt.CountryRepositoryImpl
import com.example.practica.domain.repository.CountryRepository.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCountryApi(): CountryApi {
        return Retrofit.Builder()
            .baseUrl("https://restcountries.com/v3.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCountryRepository(api: CountryApi): CountryRepository {
        return CountryRepositoryImpl(api)
    }
}
