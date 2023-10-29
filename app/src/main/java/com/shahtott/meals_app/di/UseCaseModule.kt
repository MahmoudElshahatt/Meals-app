package com.shahtott.meals_app.di

import com.shahtott.domain.repo.MealsRepository
import com.shahtott.domain.usecase.GetMealsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun  provideGetMealsUseCase(mealsRepository: MealsRepository): GetMealsUseCase {
        return GetMealsUseCase(mealsRepository)
    }
}