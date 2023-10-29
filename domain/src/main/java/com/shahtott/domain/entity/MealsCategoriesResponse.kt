package com.shahtott.domain.entity


import androidx.annotation.Keep

@Keep
data class MealsCategoriesResponse(
    val categories: List<Category?>? = null
){
    @Keep
    data class Category(
        val idCategory: String? = null, // 1
        val strCategory: String? = null, // Beef
        val strCategoryDescription: String? = null, // Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]
        val strCategoryThumb: String? = null // https://www.themealdb.com/images/category/beef.png
    )
}