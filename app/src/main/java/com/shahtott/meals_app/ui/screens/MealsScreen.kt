package com.shahtott.meals_app.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shahtott.domain.entity.MealsCategoriesResponse
import com.shahtott.meals_app.ui.composable.MealItem
import com.shahtott.meals_app.ui.theme.Meals_appTheme
import com.shahtott.meals_app.ui.viewmodel.MealsViewModel


@Composable
fun MealsScreen(
    viewModel: MealsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MealsContent(
        state
    )
}

@Composable
fun MealsContent(state: MealsCategoriesResponse?) {
    LazyColumn(modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp),
        content = {
            items(state?.categories ?: emptyList()) {
                MealItem(category = it)
            }
        })
}

