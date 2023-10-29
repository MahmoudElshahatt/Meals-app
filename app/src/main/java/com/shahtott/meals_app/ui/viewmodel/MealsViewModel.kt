package com.shahtott.meals_app.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shahtott.domain.entity.MealsCategoriesResponse
import com.shahtott.domain.usecase.GetMealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCase: GetMealsUseCase
) : ViewModel() {
    private val _state: MutableStateFlow<MealsCategoriesResponse?> =
        MutableStateFlow(null)
    val state = _state.asStateFlow()


    init {
        getMeals()
    }

    private fun getMeals() {
        // GetUserFlowUseCase
        viewModelScope.launch {
            _state.update { getMealsUseCase() }
        }
    }

}