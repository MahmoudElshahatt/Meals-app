package com.shahtott.data.repository

import com.shahtott.data.remote.ApiService
import com.shahtott.domain.entity.MealsCategoriesResponse
import com.shahtott.domain.repo.MealsRepository

class MealsRepositoryImpl(
    private val api: ApiService
) : MealsRepository {
    override fun getMealsFromRemote(): MealsCategoriesResponse =
        api.getMeals()

}