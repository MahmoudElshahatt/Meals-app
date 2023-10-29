package com.shahtott.meals_app.ui.screens

import android.service.autofill.OnClickAction
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shahtott.domain.entity.MealsCategoriesResponse
import com.shahtott.meals_app.ui.composable.MealItem
import com.shahtott.meals_app.ui.composable.SpaceVertical6
import com.shahtott.meals_app.ui.viewmodel.MealsViewModel


@Composable
fun MealsScreen(
    viewModel: MealsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current
    MealsContent(
        state
    ) {
        Toast.makeText(context, it.strCategory, Toast.LENGTH_SHORT).show()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MealsContent(
    state: MealsCategoriesResponse?,
    onClickAction: (MealsCategoriesResponse.Category) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            stickyHeader {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Color.White
                        )
                        .padding(12.dp), text = "Meals Categories",
                    fontWeight = FontWeight.Medium
                )
                SpaceVertical6()
            }
            items(
                items = state?.categories ?: emptyList(),
                key = { currentMeal ->
                    currentMeal?.idCategory ?: ""
                }
            ) {
                MealItem(modifier = Modifier.animateItemPlacement(), category = it) { category ->
                    onClickAction(category)
                }
            }
        })
}

