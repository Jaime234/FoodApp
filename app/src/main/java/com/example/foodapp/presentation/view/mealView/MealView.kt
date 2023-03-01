package com.example.foodapp.presentation.view.mealView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import kotlin.reflect.full.memberProperties
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.foodapp.data.model.MealModel
import com.example.foodapp.presentation.view.mealView.components.Image
import com.example.foodapp.presentation.view.mealView.components.IngredientsTable
import com.example.foodapp.presentation.view.mealView.components.Instructions
import com.example.foodapp.presentation.view.mealView.components.Title
import com.example.foodapp.ui.theme.Teal200

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun  MealView(viewModel: MealViewModel, id:String){
    viewModel.getMealsById(id)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = true)
    val meal: MealModel? by viewModel.meal.observeAsState()

    if(isLoading){
        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    }else{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Teal200)
                .verticalScroll(rememberScrollState())
        ){

            Image(meal = meal)

            Title(text = meal?.meal)

            IngredientsTable(meal = meal)

            Title(text = "Instructions :")

            Instructions(instructions = meal?.instructions)

        }

    }

}