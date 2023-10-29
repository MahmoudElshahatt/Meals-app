package com.shahtott.domain.repo

import com.shahtott.domain.entity.MealsCategoriesResponse

interface MealsRepository {
    suspend fun getMealsFromRemote(): MealsCategoriesResponse
}