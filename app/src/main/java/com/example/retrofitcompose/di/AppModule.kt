package com.example.retrofitcompose.di

import com.example.retrofitcompose.api.SimpleApi
import com.example.retrofitcompose.repository.Repository
import com.example.retrofitcompose.utils.Constants.Companion.BASE_URl
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

    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit):SimpleApi{
        return retrofit.create(SimpleApi::class.java)
    }
    @Singleton
    @Provides
    fun provideRepository(api:SimpleApi):Repository{
        return Repository(api)
    }


}