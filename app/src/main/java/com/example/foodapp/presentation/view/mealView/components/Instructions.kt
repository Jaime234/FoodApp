package com.example.foodapp.presentation.view.mealView.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun Instructions(instructions : String?){
    instructions?.let {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
            Text(
                text = instructions,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center),
                style = MaterialTheme.typography.h1.copy(
                    color = Color.Black,
                    fontSize = 24.sp,
                )
            )
        }
    }
}