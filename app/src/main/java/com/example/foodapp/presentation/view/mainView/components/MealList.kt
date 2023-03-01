package com.example.foodapp.presentation.view.mainView.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.foodapp.data.model.MealModel
import com.example.foodapp.navigation.Screen

@Composable
fun mealList(isLoading: Boolean, mealsList: List<MealModel>?, navController: NavController){

    if (isLoading) {

        Box(Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }

    } else if(mealsList != null){

        LazyColumn {
            items(mealsList) { meal ->
                    CardView(meal , onClick = {navController.navigate(Screen.MealView.withArgs(meal.id))})
            }

        }
    }
}