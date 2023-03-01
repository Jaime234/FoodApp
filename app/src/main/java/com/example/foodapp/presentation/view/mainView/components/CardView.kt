package com.example.foodapp.presentation.view.mainView.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodapp.data.model.MealModel

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterialApi::class)
@Composable
fun CardView(meal: MealModel, onClick : () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .absolutePadding(left = 6.dp, right = 6.dp, top = 10.dp, bottom = 10.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp,
        onClick = onClick
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Column(
                Modifier.background(Color.Cyan)
            ) {
                GlideImage(
                    model = meal.thumbUrl,
                    contentDescription = "Image of a " + meal.meal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = meal.meal,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

            }
        }
    }
}