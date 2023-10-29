package com.shahtott.meals_app.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation

@Composable
fun CircularImage(
    modifier: Modifier,
    imageUrl: String,
    contentDescription: String = ""
) {
    Image(
        painter = rememberImagePainter(
            data = imageUrl,
            builder = {
                scale(Scale.FILL)
                transformations(CircleCropTransformation())
            }
        ), contentDescription = contentDescription,
        modifier = modifier
    )
}