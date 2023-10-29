package com.shahtott.meals_app.di

import com.shahtott.data.remote.ApiService
import com.shahtott.data.repository.MealsRepositoryImpl
import com.shahtott.domain.repo.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMealsRepo(apiService: ApiService): MealsRepository {
        return MealsRepositoryImpl(apiService)
    }
}