package com.shahtott.meals_app.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shahtott.domain.entity.MealsCategoriesResponse
import com.shahtott.meals_app.ui.theme.Meals_appTheme

@Composable
fun MealItem(
    modifier: Modifier = Modifier,
    category: MealsCategoriesResponse.Category?,
    onClick: (MealsCategoriesResponse.Category) -> Unit
) {
    Card(
        modifier = modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(110.dp), shape = RoundedCornerShape(8.dp), elevation = 4.dp
    ) {
        Surface{

            Row(
                Modifier
                    .clickable {
                        if (category != null) {
                            onClick(category)
                        }
                    }
                    .padding(4.dp)
                    .fillMaxSize()

            ) {

                CircularImage(
                    Modifier
                        .fillMaxHeight()
                        .weight(0.2f),
                    category?.strCategoryThumb ?: "",
                    category?.strCategoryDescription ?: ""
                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .weight(0.65f)
                ) {
                    Text(
                        text = category?.strCategory ?: "",
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold
                    )
                    SpaceVertical6()
                    Text(
                        text = category?.strCategoryDescription ?: "",
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(4.dp)
                    )

                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Meals_appTheme {
        MealItem(
            category = MealsCategoriesResponse.Category(
                "1", "Fwsfwe", "wdfsd",
                "dsfds"
            ), onClick = {

            }
        )
    }
}

