package com.example.foodapp.presentation.view.mealView.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodapp.data.model.MealModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun Image(meal: MealModel?){
    GlideImage(
        model = meal?.thumbUrl,
        contentDescription = "Image of a " + meal?.meal,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        contentScale = ContentScale.Crop
    )
}