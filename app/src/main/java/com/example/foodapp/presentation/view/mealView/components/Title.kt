package com.example.foodapp.presentation.view.mealView.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title(text : String?){
    text?.let {
        Text(
            text = it,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .wrapContentSize(align = Alignment.Center),
            style = MaterialTheme.typography.h1.copy(
                color = Color.Black,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            )
        )
    }
}