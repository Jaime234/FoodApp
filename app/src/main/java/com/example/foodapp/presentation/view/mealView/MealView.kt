package com.example.foodapp.presentation.view.mealView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.foodapp.data.model.MealModel
import com.example.foodapp.presentation.view.mealView.components.Image
import com.example.foodapp.presentation.view.mealView.components.IngredientsTable
import com.example.foodapp.presentation.view.mealView.components.Instructions
import com.example.foodapp.presentation.view.mealView.components.Title
import com.example.foodapp.ui.theme.Teal200

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