package com.shahtott.data.remote

import com.shahtott.domain.entity.MealsCategoriesResponse
import retrofit2.http.GET

interface ApiService {

    @GET("categories.php")
    suspend fun getMeals(): MealsCategoriesResponse

}